package com.codeblock_;

/**
 * @ClassName: Block2
 * @Description:
 * 演示构造器中隐藏的super和调用普通代码块
 * 演示创建子类对象时类成员调用顺序
 * @date: 2023-03-08 10:48
 */
public class Block2 {
    public static void main(String[] args) {
        new BB();//创建含有继承关系的子类对象
        new BB();
    }
}

class AA {
    private static int val = getVal();

    public static int getVal() {
        System.out.println("父类的静态变量初始化被调用");//(1)
        return 1;
    }

    static {
        System.out.println("父类的静态代码块被调用");//(2)
    }

    private int val2 = getVal2();

    public int getVal2() {
        System.out.println("父类的普通变量初始化被调用");//(5)
        return 2;
    }

    {
        System.out.println("父类的普通代码块被调用");//(6)
    }

    public AA() {
        //隐藏super()(5)
        //隐藏了调用此类普通代码块和普通属性初始化(5和6)
        System.out.println("父类构造器内容被调用");//(7)
    }
}

class BB extends AA{
    static {
        System.out.println("子类的静态代码块被调用");//(3)
    }

    private static int val3 = getVal3();

    public static int getVal3() {
        System.out.println("子类的静态变量初始化被调用");//(4)
        return 3;
    }

    private int val4 = getVal4();

    {
        System.out.println("子类的普通代码块被调用");//(8)
    }

    public int getVal4() {
        System.out.println("子类的普通变量初始化被调用");//(9)
        return 4;
    }

    public BB() {
        //隐藏super() (5)
        //隐藏了调用此类普通代码块和普通属性初始化(8和9)
        System.out.println("子类构造器内容被调用");//(10)
    }
}