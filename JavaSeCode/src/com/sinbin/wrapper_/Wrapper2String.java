package com.sinbin.wrapper_;

/**
 * @Project: JavaSeCode
 * @File: null.java
 * @Author: SinbinZhou
 * @Date: 2024/11/11 13:31
 * @Description:
 */
public class Wrapper2String {
    public static void main(String[] args) {
        Integer i = 2002;
        // f1
        String s1 = i + "";
        // f2
        String s2 = i.toString();
        // f3
        String s3 = String.valueOf(i);


        // 调用自动装箱
        Integer i1 = Integer.parseInt(s1);

        Integer i2 = new Integer(s1);
    }
}
