package com.polymorphic.poly4;

public class Detail02 {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b instanceof B);  //true
        System.out.println(b instanceof A);  //true

        A a = new B();
        System.out.println(a instanceof B);  //true
        System.out.println(a instanceof A);  //true

        Object obj = new Object();
        System.out.println(obj instanceof A);  //false
        System.out.println(obj instanceof B);  //false
    }
}
class A {}
class B extends A{}
