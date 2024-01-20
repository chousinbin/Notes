package com.Extends;

public class test2 {
    public static void main(String[] args) {
        B b = new B();  //1
        /**
         * 输出:
         * a
         * b name
         * b
         */
    }
}

class A {
    A() {
        System.out.println("a");  //4
    }
    A(String name) {
        System.out.println("a name");
    }
}

class B extends A{
    B() {

        this("abc");  //2
        System.out.println("b");  //6
    }
    B(String name) {
        //这里第一行默认有一个super()调用A类的无参构造器  //3
        System.out.println("b name");  //5
    }
}
