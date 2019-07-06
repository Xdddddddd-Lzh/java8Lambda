package com.liang.javaeight.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyProcessorTest {


    public static String processfile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("resource/data.txt"))) {
            return p.process(br);
        }
    }

    //Lambda表达式应用案例2
    public static void main(String[] args) throws IOException {
        //就在这里使用Lambda表达式
        processfile((BufferedReader br) -> br.readLine() + br.readLine());
    }
}
