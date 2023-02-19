package com.Extends.test1;

public class test {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.sayInfo();

        //不管用哪个子类构造器, 父类构造器均被提前调用
        Sub sub2 = new Sub("abc");
    }
}
