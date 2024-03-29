package com.liang.javaeight.entity;

public class Apple {

    private Integer weight;
    private String color;


    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple() {
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

//    public boolean isRed(Apple apple){
//        if("red".equals(apple.getColor())){
//            return true;
//        }
//        return false;
//    }
}
