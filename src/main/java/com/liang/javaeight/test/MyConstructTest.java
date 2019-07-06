package com.liang.javaeight.test;

import com.liang.javaeight.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyConstructTest {

    //案例3所用方法
    public static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f) {
        List<Apple> apples = new ArrayList<>();
        for (Integer weight : weights) {
            apples.add(f.apply(weight));
        }
        return apples;
    }

    public static void main(String[] args) {

        //注意：实体类必须有相对应的构造函数
        //1.利用构造函数 创建对象
//        Supplier<Apple> s = ()->new Apple();
        Supplier<Apple> s = Apple::new;
        Apple apple = s.get();

        //2.利用带参构造函数 创建对象
        Function<Integer, Apple> f = Apple::new;
        Apple apple2 = f.apply(100);
        System.out.println("案例2：苹果重量=" + apple2.getWeight());

        //Lambda构造函数应用案例3
        List<Integer> weights = Arrays.asList(50, 25, 22, 45, 78);
        List<Apple> appleList = map(weights, Apple::new);
        for (Apple apple1 : appleList) {
            System.out.println("案例3：苹果重量=" + apple1.getWeight());
        }

        //Lambda构造函数应用案例4
        BiFunction<Integer, String, Apple> bf = Apple::new;
        Apple apple4 = bf.apply(88, "red");
        System.out.println("案例4：苹果重量=" + apple4.getWeight() + ",苹果颜色=" + apple4.getColor());
    }

}
