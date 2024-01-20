package com.Extends.test1;

//父类Base
public class Base {
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;


    public Base() {
        System.out.println("父类构造器Base()被调用...");
    }
    public Base(String name) {
        System.out.println("父类构造器Base(String name)被调用...");
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


    //提供一个public方法,返回私有属性n4
    public int getN4() {
        return n4;
    }
    //提供一个public方法, 间接访问私有的方法test4
    public void callTest4() {
        test4();
    }
}
