package com.sinbin.hashset_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/16 17:00
 * @Description:
 * 定义一介Employee.类，该类包含：private成员属性name,age要求：
 * 创建3个Employee对象放入HashSet中
 * 当name和age的值相同时，认为是相同员工，不能添加州ashSet.集合中
 */
public class Test02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("zxb", 22));
        hashSet.add(new Employee("zxb", 22));
        hashSet.add(new Employee("zxb", 21));
        System.out.println(hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
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
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
