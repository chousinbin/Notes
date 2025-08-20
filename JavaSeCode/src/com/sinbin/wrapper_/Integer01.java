package com.sinbin.wrapper_;

/**
 * @Project: JavaSeCode
 * @File: null.java
 * @Author: SinbinZhou
 * @Date: 2024/11/11 11:08
 * @Description:
 */
public class Integer01 {
    public static void main(String[] args) {
        int n1 = 100;
        // 手动装箱
        Integer integer01 = new Integer(n1);
        Integer integer02 = Integer.valueOf(n1);
        System.out.println(integer01 == integer02);

        // 手动拆箱
        int i = integer02.intValue();

        // 自动装箱：底层使用 Integer.valueOf(n1)
        Integer integer03 = n1;

        // 自动拆箱：底层使用 integer03.intValue()
        int i2 = integer03;

        System.out.println(i2);
    }
}
