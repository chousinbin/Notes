package com.sinbin.string_;

/**
 * @Project: JavaSeCode
 * @File: null.java
 * @Author: SinbinZhou
 * @Date: 2024/11/11 14:07
 * @Description:
 */
public class String01 {
    public static void main(String[] args) {
        String s1 = "zxb";
        String s2 = new String("zxb");

        System.out.println(s1 == s1.intern());
        System.out.println(s2 == s2.intern());

        exec();
    }

   static void exec() {
        Person p1 = new Person();
        p1.name = "hspedu";
        Person p2 = new Person();
        p2.name = "hspedu";

        System.out.println(p1.name.equals(p2.name)); // T
        System.out.println(p1.name == p2.name); // T
        System.out.println(p1.name == "hspedu"); // T

        String s1 = new String("bcde");
        String s2 = new String("bcde");
        System.out.println(s1 == s2); // F
    }
}


class Person {
    public String name;
}
