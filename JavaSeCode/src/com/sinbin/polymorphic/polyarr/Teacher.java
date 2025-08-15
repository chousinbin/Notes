package com.sinbin.polymorphic.polyarr;

/**
 * @ClassName: Teacher
 * @Description:
 * @author: sinBin
 * @date: 2023-02-23 11:24
 * @version: 1.0
 */
public class Teacher extends Person{
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String say() {
        return super.say() + "\t" + salary;
    }

    public void teach() {
        System.out.println("老师" + getName() + "正在授课");
    }
}
