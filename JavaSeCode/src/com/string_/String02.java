package com.string_;

/**
 * @Project: JavaSeCode
 * @File: null.java
 * @Author: SinbinZhou
 * @Date: 2024/11/11 17:44
 * @Description:
 */
public class String02 {
    public static void main(String[] args) {
        String name = "zxb";
        int age = 22;
        double score = 99.5;

        String res = String.format("我的姓名是 %s，" +
                "我的成绩是 %.2f," +
                "我的年龄是 %d",
                name, score, age);

        System.out.println(res);
    }
}
