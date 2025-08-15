package com.sinbin.super_;

public class B extends A{

    //访问父类的属性, 不能访问私有属性
    public void hi() {
        System.out.println(super.n1);
        System.out.println(super.n2);
        System.out.println(super.n3);
    }

    //访问父类方法, 不能访问私有方法
    public void hii() {
        super.test1();
        super.test2();
        super.test3();
    }

    //调用父类构造器
    public B() {
        super("abc");
    }
}
