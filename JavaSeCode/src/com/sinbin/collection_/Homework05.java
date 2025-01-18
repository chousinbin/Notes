package com.sinbin.collection_;

import java.util.TreeSet;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/21 12:25
 * @Description: 猜一下会不会报异常？
 */
public class Homework05 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        /*
            add 方法因为采用无参构造器，没有传入 Comparator 匿名内部类
            所以底层调用 Comparable<? super K> k = (Comparable<? super K>) key;
            即尝试把 Person 转换成 Comparable 类型，默认是无法转换的
            需要实现 Comparable 接口
         */
        treeSet.add(new Person("zxb", 22));
    }
}

class Person implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age) {
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

    @Override
    public int compareTo(Object o) {
        return name.compareTo((String)o);
    }
}
