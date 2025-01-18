package com.sinbin.math_;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 10:43
 * @Description:
 */
public class MathFunction {
    public static void main(String[] args) {
        int a = -9;
        System.out.println(Math.abs(a));

        System.out.println(Math.pow(a, 2));
        // 向上取整
        System.out.println(Math.ceil(-9.1));

        System.out.println(Math.min(1, -1.5));
    }
}
