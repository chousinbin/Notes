package com.sinbin.modifier;

public class test {

    public static void main(String[] args) {
        /*
        在同包同类中访问
        */
        A a = new A();
        a.m1();

        /*
        在同包不同类中
        */
        B b = new B();
        b.m2();


    }


}
