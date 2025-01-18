package com.sinbin.interface_;

/**
 * @ClassName: Exercise
 * @Description:
 * @date: 2023-03-12 19:24
 */
public class Exercise {
    public static void main(String[] args) {
        C.use();
    }
}

interface A {
    int x = 0;
}

class B {
    int x = 1;
}

class C extends B implements A {
    int x = 2;
    public void pX() {
        //System.out.println(x); x使用错误, x不明确
        //用super.x使用B类的x
        //用A.x使用A类的x
        //用C类的使用x

        System.out.println(x + " " + super.x + " " + A.x);
    }
    public static void use() {
        new C().pX();
    }
}
