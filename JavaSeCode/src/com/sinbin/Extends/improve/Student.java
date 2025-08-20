package com.sinbin.Extends.improve;
//父类,
public class Student {
    //共有属性
    public String name;
    public int age;
    private double score;

    //共有方法
    public void setScore(double score) {
        this.score = score;
    }

    public void showInfo() {
        System.out.println("name " + name + " age " + age + " score " + score);
    }

}
