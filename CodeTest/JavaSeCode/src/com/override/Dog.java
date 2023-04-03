package com.override;
/**
 *Dog类是Animal的子类
 * 两个类中的say()方法定义形式一样
 * 这就是Dog的say()方法重写了Animal的say()方法
 */
public class Dog extends Animal{
    public void say() {
        System.out.println("汪汪汪");
    }

    public String sayOk() {
        return null;
    }
}
