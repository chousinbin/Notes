package com.super_.test1;

public class B extends  A{
    protected int  n1 = 2;

    public void say() {
        System.out.println("我是孙子");
    }

    public void test() {
        System.out.println(super.n1);
    }

    public void test2() {
        super.say();
    }

    public void test3() {
        //super.n2;
    }
}
