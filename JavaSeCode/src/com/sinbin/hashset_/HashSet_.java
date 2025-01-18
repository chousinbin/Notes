package com.sinbin.hashset_;

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

        /*
            根据源码判重的条件
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
            虽然是两个不同的 String 对象，但是内容相同，所以不会重复添加
         */
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
