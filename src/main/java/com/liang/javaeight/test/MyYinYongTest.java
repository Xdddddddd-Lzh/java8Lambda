package com.liang.javaeight.test;

import com.liang.javaeight.entity.Apple;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MyYinYongTest {

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

    public static void main(String[] args) {
        Apple redApple = returnApple("red", 100);
        Apple blueApple = returnApple("blue", 80);
        Apple blueApple2 = returnApple("blue", 72);
        Apple orangeApple = returnApple("orange", 72);
        Apple orangeApple2 = returnApple("orange", 80);

        List<Apple> appleList = Arrays.asList(blueApple, redApple, orangeApple,blueApple2,orangeApple2);

        for (Apple apple : appleList) {
            System.out.println("原始每个苹果的情况：重量：" + apple.getWeight() + ",颜色：" + apple.getColor());
        }

        //Lambda方式1
        //appleList.sort((Apple a1, Apple a2) -> a2.getWeight().compareTo(a1.getWeight()));

        //Lambda方式2 利用Comparator.comparing()静态方法,返回一个Comparator
        //appleList.sort(Comparator.comparing((Apple a)->a.getWeight()));

        //Lambda方法3：方法引用
        appleList.sort(Comparator.comparing(Apple::getWeight));

        //Lambda方法4：逆序
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed());

        //Lambda方法5：比较器链
        appleList.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));


        for (Apple apple : appleList) {
            System.out.println("案例4：排序后的苹果的重量=" + apple.getWeight() + ",苹果颜色=" + apple.getColor());
        }

    }


}
