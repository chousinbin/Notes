package com.object_;

/**
 * @ClassName: EqualTest
 * @Description:
 * @date: 2023-03-06 16:40
 */
public class EqualTest {
    public static void main(String[] args) {
        Person p1 = new Person("bin", 20, 'a');
        Person p2 = new Person("jin", 18, 'a');
        Person p3 = new Person("bin", 20, 'a');

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));
    }
}

class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean equals(Object obj) {
        //同一个对象成员属性肯定相等
        if(obj == this) {
            return true;
        }
        if(obj instanceof Person) {
            Person p = (Person)obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
        }
        return false;
    }
}
