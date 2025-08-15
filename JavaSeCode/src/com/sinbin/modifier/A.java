package com.sinbin.modifier;

public class A {
    //4个不同访问修饰符的属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    //该方法可以访问四个属性
    public void m1() {
        System.out.println("n1=" + n1);
        System.out.println("n2=" + n2);
        System.out.println("n3=" + n3);
        System.out.println("n4=" + n4);
    }
}