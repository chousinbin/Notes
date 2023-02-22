package com.polymorphic.poly2;

/**
 * 方法的多态
 * 重写和重载
 */
public class PolyMethod {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        //方法重写体现多态
        a.say();
        b.say();
        //方法重载体现多态
        System.out.println(b.sum(1, 2));
        System.out.println(b.sum(1, 2, 3));
    }
}

class A {
    public void say() {
        System.out.println("A say()被调用");
    }
}

class B extends A {
    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int sum(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    public void say() {
        System.out.println("B say()被调用");
    }
}
