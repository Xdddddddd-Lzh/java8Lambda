package com.liang.javaeight.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MyTest {


    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    //Lambda表达式应用案例1
    public static void main(String[] args) {
        List<String> strlist = new ArrayList<>();
        strlist.add("hi");
        strlist.add("");
        strlist.add("heihei");

//        filter(strlist,(String s)->{return s.isEmpty();});
        List<String> resultStr = filter(strlist, (String s) -> s.length() >= 2);
        for (String s : resultStr) {
            System.out.println(s.length());
        }
        System.out.println("集合大小：" + resultStr.size());

    }
}
