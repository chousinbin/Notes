package com.sinbin.encapsulation;

/*
    不能随便查看人的年龄和工资等隐私
    并对设置的年龄进行合理的验证
    年龄合理就设置, 否则默认
    年龄在1~120
    name长度在2~6之间
*/
public class encapsulation {
    public static void main(String[] args) {
        Person p1 = new Person();

        //靠方法修改值
        p1.setAge(20);
        p1.setName("周新斌");
        p1.setSalary(2000);

        //靠方法查看值
        System.out.println(p1.getName());
        System.out.println(p1.getAge());
        System.out.println(p1.getSalary());

        //构造方法与set结合
        Person p2 = new Person("新斌", 0, 1000);
        System.out.println(p2.getName());
        System.out.println(p2.getAge());
        System.out.println(p2.getSalary());
    }
}

class Person {
    public String name;
    private int age;
    private double salary;

    public Person() {

    }

    public Person(String name, int age, double salary) {
        //构造器与set相结合
        setName(name);
        setAge(age);
        setSalary(salary);
    }
    public void setAge(int age) {
        if(age < 1 || age > 120) {
            System.out.println("年龄需要在1~120");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >=2 && name.length() <=6) {
            this.name = name;
        } else {
            System.out.println("字符串长度需要在2~6");
            this.name = "null";
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}