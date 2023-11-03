package com.exception_.runningexception;

/**
 * @ClassName: ClassCast
 * @Description:
 * @date: 2023-03-24 11:47
 */
public class ClassCast {
    public static void main(String[] args) {
        A a = new B();
        B b = (B) a;
        C c = (C) a;

    }
}

class A {}
class B extends A {}
class C extends A {}
