package com.sinbin.final_;

/**
 * @ClassName: Test1
 * @Description:
 * @date: 2023-03-09 11:26
 */
public class Test1 {
    public static void main(String[] args) {
        Circle circle = new Circle(9.0);
        System.out.println(circle.getS());
    }
}

class Circle {
    private double radius;
    private final double PI = 3.14;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getS() {
        return PI * radius * radius;
    }

    public double getPI() {
        //PI++; 不可以操作, 不能修改PI值
        return PI + 1;  //可以操作因为没有对PI进行修改
    }
}
