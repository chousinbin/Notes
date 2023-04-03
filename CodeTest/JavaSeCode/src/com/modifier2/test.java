package com.modifier2;

import com.modifier.A;

public class test {
    public static void main(String[] args) {
        A a = new A();
        /*
            不同包只能访问public
         */
        System.out.println(a.n1);
    }
}
