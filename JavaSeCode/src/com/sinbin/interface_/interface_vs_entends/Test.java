package com.sinbin.interface_.interface_vs_entends;

/**
 * @ClassName: Test
 * @Description:
 * 演示接口对子类单继承的补充作用
 * @date: 2023-03-12 10:22
 */
public class Test {
    public static void main(String[] args) {
        jinSiHou wuKong = new jinSiHou("悟空");
        wuKong.climbing();
        wuKong.swimming();
        wuKong.flying();
    }
}

class Monkey {
    String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println(name + "会爬树");
    }

    public String getName() {
        return name;
    }
}

interface Fish {
    void swimming();
}

interface Bird {
    void flying();
}

class jinSiHou extends Monkey implements Fish, Bird{
    public jinSiHou(String name) {
        super(name);
    }


    @Override
    public void swimming() {
        System.out.println(getName() + "通过学习会游泳");
    }

    @Override
    public void flying() {
        System.out.println(getName() + "通过学习会爬树");
    }
}
