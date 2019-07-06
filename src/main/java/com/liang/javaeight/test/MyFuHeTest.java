package com.liang.javaeight.test;

import com.liang.javaeight.entity.Apple;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyFuHeTest {

    //案例4：引用实战
    public static Map<String, Function<Integer, Apple>> map = new HashMap<>();

    static {
        map.put("red", Apple::new);
        map.put("orange", Apple::new);
        map.put("blue", Apple::new);
    }

    //根据输入的颜色和重量，来创建苹果对象
    public static Apple returnApple(String color, Integer weight) {
        Apple a = map.get(color).apply(weight);
        a.setColor(color);
        return a;
    }

    //根据要求来筛选 同类的苹果
    public static List<Apple> filter(List<Apple> appleList, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Apple redApple = returnApple("red", 100);
        Apple blueApple = returnApple("blue", 80);
        Apple blueApple2 = returnApple("blue", 72);
        Apple orangeApple = returnApple("orange", 72);
        Apple orangeApple2 = returnApple("orange", 80);

        List<Apple> appleList = Arrays.asList(blueApple, redApple, orangeApple, blueApple2, orangeApple2);


        //案例5：使用谓词复合
        //红苹果数量
        Predicate<Apple> redPredicate = (Apple a) -> "red".equals(a.getColor());
        List<Apple> redAppleList = filter(appleList, redPredicate);
        System.out.println("红苹果的数量：" + redAppleList.size());

        //不是红苹果的数量
        Predicate<Apple> notRedPredicate = redPredicate.negate();
        List<Apple> notRedAppleList = filter(appleList, notRedPredicate);
        System.out.println("不是红苹果的数量：" + notRedAppleList.size());
 
        //既是红苹果又是重苹果的数量
        Predicate<Apple> redAndHeavyPredicate = redPredicate.and((Apple a) -> a.getWeight() >= 80);
        List<Apple> redAndHeavyAppleList = filter(appleList, redAndHeavyPredicate);
        System.out.println("既是红苹果又是重苹果的数量：" + redAndHeavyAppleList.size());

        //不是红苹果,却是重苹果的数量
        Predicate<Apple> notRedAndHeavyPredicate = redPredicate.negate().and((Apple a) -> a.getWeight() >= 80);
        List<Apple> NotRedAndHeavyAppleList = filter(appleList, notRedAndHeavyPredicate);
        System.out.println("不是红苹果,却是重苹果的数量：" + NotRedAndHeavyAppleList.size());

        //是红苹果或是蓝苹果的 数量
        Predicate<Apple> redOrBluePredicate = redPredicate.or((Apple a) -> "blue".equals(a.getColor()));
        List<Apple> redOrBlueAppleList = filter(appleList, redOrBluePredicate);
        System.out.println("是红苹果或是蓝苹果的 数量：" + redOrBlueAppleList.size());
    }
}
