package com.sinbin.super_;

public class A {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;


    public A () {
        System.out.println("调用构造器A ()");
    }
    public A (String name) {
        System.out.println("调用构造器A (String name)");
    }


    public void test1() {
        System.out.println("test1");
    }
    protected void test2() {
        System.out.println("test2");
    }
    void test3() {
        System.out.println("test3");
    }
    private void test4() {
        System.out.println("test4");
    }


}
