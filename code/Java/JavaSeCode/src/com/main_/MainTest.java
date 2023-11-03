package com.main_;

/**
 * @ClassName: MainTest
 * @Description:
 * @date: 2023-03-07 19:59
 */
public class MainTest {
    String name;
    static String nation = "CN";

    static void f1() {
        System.out.println("f1");
    }

    public static void main(String[] args) {
        /**
         * main()内可以直接访问所在类的静态属性
         */
        System.out.println(nation);
        f1();
        /**
         * main()方法内要访问非静态属性, 要先创建对象, 在通过对象引用
         */
        //System.out.println(name);
        MainTest mainTest = new MainTest();
        System.out.println(mainTest.name);
    }
}
