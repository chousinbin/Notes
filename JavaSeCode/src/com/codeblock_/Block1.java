package com.codeblock_;

/**
 * @ClassName: Block1
 * @Description:演示创建一个对象时,类成员的调用顺序
 * @date: 2023-03-07 20:34
 */
public class Block1 {
    public static void main(String[] args) {
        A a = new A("a");
        System.out.println(a.name);
        /**
         * out:
         * 静态方法被调用
         * 普通代码块被调用
         * 普通方法被调用
         * 构造方法被调用
         * a
         */
    }
}

class A {
    static {
        System.out.println("静态代码块被调用");
    }

    private static int age = getAge();

    public static int getAge() {
        System.out.println("静态方法被调用");
        return 100;
    }

    {
        System.out.println("普通代码块被调用");
    }

    String name = getName();

    public String getName() {
        System.out.println("普通方法被调用");
        return "bin";
    }

    public A(String name) {
        this.name = name;
        System.out.println("构造方法被调用");
    }
}


