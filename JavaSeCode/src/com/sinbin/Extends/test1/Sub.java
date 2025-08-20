package com.sinbin.Extends.test1;
//子类Sub访问主类
public class Sub extends Base{
    public Sub() {
        super();
        /*
            当子类为Sub()构造器时
            指定主类调用Base()构造器
         */
        System.out.println("子类构造器Sub()被调用...");
    }
    public Sub(String name) {
        super("abc");
        /*
            当子类为Sub(String name)构造器时
            指定主类调用Base(String name)构造器
         */
        System.out.println("子类构造器Sub(String name)被调用...");
    }


    public void sayInfo() {
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(getN4());  //私有的属性在子类不能访问

        test1();
        test2();
        test3();
        callTest4();  //私有的方法在子类不能访问
    }

}
