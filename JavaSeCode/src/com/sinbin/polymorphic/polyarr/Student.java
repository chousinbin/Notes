package com.sinbin.polymorphic.polyarr;

/**
 * @ClassName: Student
 * @Description:
 * @author: sinBin
 * @date: 2023-02-23 11:21
 * @version: 1.0
 */
public class Student extends Person{
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + "\t" + score;
    }

    public void study() {
        System.out.println("学生" + getName() + "正在上课");
    }
}
