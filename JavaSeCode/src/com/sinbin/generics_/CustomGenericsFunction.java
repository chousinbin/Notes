package com.sinbin.generics_;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/22 16:27
 * @Description:
 */
public class CustomGenericsFunction {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly(1,5.2);
    }
}

class Car {
    public<T, R> void fly(T t, R r) {
        System.out.println(t + " " + r);
    }

//    public void run(T t) {
//
//    }
}
