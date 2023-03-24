package com.exception_;

/**
 * @ClassName: Test01
 * @Description:
 * 异常入门
 * @date: 2023-03-24 10:26
 */
public class ArithmeticException {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 0;

        int res = n1 / n2;  //抛出异常
        System.out.println("程序正在运行");  //从此不再执行
    }
}
