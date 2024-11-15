package com.hashset_;

import java.util.HashSet;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/15 15:38
 * @Description:
 */
public class HashSet_ {
    public static void main(String[] args) {
        HashSet objects = new HashSet();

        objects.add(null);
        objects.add(null);
        objects.add(new Dog("tom"));
        objects.add(new Dog("tom"));
        System.out.println(objects);

        objects.add(new String("zxb"));
        objects.add(new String("zxb"));
        System.out.println(objects);
    }
}
class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
