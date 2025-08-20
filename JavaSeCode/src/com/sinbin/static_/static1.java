package com.sinbin.static_;

/**
 * @ClassName: static1
 * @Description:类对象
 * @date: 2023-03-06 20:41
 */
public class static1 {
    public static void main(String[] args) {
        Person.nation = "China";
        Person p1 = new Person("bin", 20);
        Person p2 = new Person("jin", 18);

        System.out.println(p1.nation);
        System.out.println(p2.nation);

        p1.nation = "CN";
        System.out.println(p1.nation);
        System.out.println(p2.nation);

    }
}

class Person {
    String name;
    int age;
    static String nation;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
