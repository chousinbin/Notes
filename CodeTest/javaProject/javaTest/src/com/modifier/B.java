package com.modifier;

public class B {

    public void m2() {
        A a = new A();
        /*
            在同一包中
            可以访问
            public
            protected
            默认
         */
        System.out.println("n1 = " + a.n1);
        System.out.println("n2 = " + a.n2);
        System.out.println("n3 = " + a.n3);
//        System.out.println("n4 = " + a.n4);
    }
}
