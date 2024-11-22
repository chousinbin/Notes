package com.abstract_;

/**
 * @ClassName: test
 * @Description:
 * @date: 2023-03-09 12:43
 */
public class test {
    public static void main(String[] args) {
        Manager m = new Manager("老王", 40, 10000, 5000);
        CommonEmployee c = new CommonEmployee("小李", 20, 8000);
        m.work();
        c.work();
    }
}

abstract class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public abstract void work();

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, int age, double salary, double bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    public void work() {
        System.out.println("经理" + getName() + "工作中...");
    }
}

class CommonEmployee extends Employee {
    public CommonEmployee(String name, int age, double salary) {
        super(name, age, salary);
    }

    public void work() {
        System.out.println("员工" + getName() + "工作中...");
    }
}
