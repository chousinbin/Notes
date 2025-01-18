package com.sinbin.polymorphic.denamicbinding;

/**
 * 动态绑定机制
 */
public class dynamic1 {
    public static void main(String[] args) {
        A a = new B();  //向上转型
        /*
        方法重写调用B的方法
         */
        System.out.println(a.sum());  //40
        System.out.println(a.sum1());  //30

        /*
        此时注释掉B类中的sum()
        这时运行a.sum() sum方法调用的是类A中的
        类A中的sum()中的getI方法根据动态绑定机制
        会调用B类中的getI方法
         */
        System.out.println(a.sum());  //30
        /*
        此时注释掉B类中的sum1()
        这时运行a.sum1() sum1方法调用的是类A中的
        类A中的sum1()中的属性i没有动态绑定机制
        会调用A类中的属性i
         */
        System.out.println(a.sum1());  //20
    }
}

class A {
    public int i = 10;
    public int sum() {
        return getI() + 10;
    }
    public int sum1() {
        return i + 10;
    }
    public int getI() {
        return i;
    }
}

class B extends A{
    public int i = 20;
//    public int sum() {
//        return i + 20;
//    }
    public int sum1() {
        return i + 10;
    }
    public int getI() {
        return i;
    }
}
