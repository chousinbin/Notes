package com.sinbin.Extends;
//小学生类
public class Pupil {
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public void testing() {
        System.out.println("pupil:" + name + " is testing in math...");
    }

    public void showInfo() {
        System.out.println("name " + name + " age " + age + " score " + score);
    }
}
