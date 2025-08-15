package com.sinbin.interface_.interface2;

/**
 * @ClassName: InterfaceExercise1
 * @Description:
 * @date: 2023-03-10 21:02
 */
public class InterfaceExercise1 {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(A.a);  //23
        System.out.println(b.a);  //23
        System.out.println(B.a);  //23
    }
}

interface A {
    int a = 23;
}

class B implements A {

}
