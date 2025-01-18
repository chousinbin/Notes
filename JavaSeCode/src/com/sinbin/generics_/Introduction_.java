package com.sinbin.generics_;

import java.util.ArrayList;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/21 17:48
 * @Description: P553
 */
public class Introduction_ {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("wangwang", 15));
        arrayList.add(new Dog("laixi", 5));
        arrayList.add(new Dog("laifu", 5));
        for (Object o : arrayList) {
            Dog dog = (Dog) o;
            System.out.println(dog.getName() + " " + dog.getAge());
        }

        /*
            1. 程序员可能不小心添加一只猫到 ArrayList 中，可以使用泛型对数组的对象进行限制
            2. 编历时需要额外的向下转型
                -->引出泛型
         */

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("wangwang", 15));
        dogs.add(new Dog("laixi", 5));
        dogs.add(new Dog("laifu", 5));
        for (Dog dog : dogs) {
            System.out.println(dog.getName() + " " + dog.getAge());
        }

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
