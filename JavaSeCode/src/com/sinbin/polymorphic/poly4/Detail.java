package com.sinbin.polymorphic.poly4;

/**
 * 属性没有重写之说
 */
public class Detail {
    public static void main(String[] args) {
        Base base = new Sub();  //向上转型
        System.out.println(base.count);  //10
        Sub sub = new Sub();
        System.out.println(sub.count);  //20
    }
}

class Base {
    int count = 10;
}

class Sub extends Base {
    int count = 20;
}
