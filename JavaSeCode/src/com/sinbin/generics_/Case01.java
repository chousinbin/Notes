package com.sinbin.generics_;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/21 18:30
 * @Description:
 */
public class Case01 {
    public static void main(String[] args) {
        Person<String> stringPerson = new Person<>("zxb");
        Person<Integer> person = new Person<Integer>(1);
    }
}

class Person<E> {
    private E name;

    public Person(E name) {
        this.name = name;
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
