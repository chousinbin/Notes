package com.Extends;
//大学生类
public class Graduate {
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public void testing() {
        System.out.println("graduate:" + name + " is testing in math...");
    }

    public void showInfo() {
        System.out.println("name " + name + " age " + age + " score " + score);
    }
}
