package com.sinbin.collection_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/21 12:33
 * @Description:
 */
public class Homework06 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Per p1 = new Per("zxb", 22);
        Per p2 = new Per("hsp", 50);
        hashSet.add(p1);
        hashSet.add(p2);

        p1.setName("CC");
        hashSet.remove(p1); // 无法删除，修改值导致索引发生变化，无法找到原来索引
        System.out.println(hashSet);
        /*
            CC - 22
            hsp - 50
         */

        hashSet.add(new Per("CC", 22)); // 成功添加，索引更新了
        System.out.println(hashSet);
        /*
            CC - 22
            hsp - 50
            CC - 22 新的索引位置
         */

        hashSet.add(new Per("zxb", 22)); // 成功添加，索引位置的原值修改了
        System.out.println(hashSet);
        /*
            CC - 22
            hsp - 50
            CC - 22
            zxb - 22
         */
    }
}

class Per {
    private String name;
    private int age;

    public Per(String name, int age) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Per per = (Per) o;
        return age == per.age && Objects.equals(name, per.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Per{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
