package com.sinbin.super_.test1;

/**
 * 展示访问多个父类同名属性, 就近原则
 * 展示爷爷类和孙子类如果有同名成员, 孙子类可以通过super访问爷爷类的成员
 */
public class test {
    public static void main(String[] args) {
        B b = new B();
        b.test();

        b.test2();
    }
}
