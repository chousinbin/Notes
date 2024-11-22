package com.generics_;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/22 14:19
 * @Description: P559
 * 定义Employee:类
 * 1)该类包含：private成员变量name,sal,birthday,其中birthday为MyDate类的对
 * 象；
 * 2)为每个属性是义getter,setter方法；
 * 3)重写toString方法输出name,sal,birthday
 * 。4)MyDate类包含：private成员变量month,day,year;并为每一个属性定义getter,,
 * setter方法；
 * 5)创建该类的3个对象，并把这些对象放入ArrayList集合中(ArrayList需使用泛
 * 型来定义)，对集合中的元素进行排序，并遍历输出：
 * 排序方式：调用ArrayList的sort方法，传入Comparator对象[使用泛型]，先按照
 * name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】
 */
public class Test02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("zxb", 200,
                new MyDate(2002,9,22)));
        employees.add(new Employee("hsp", 1000,
                new MyDate(1960,12,6)));
        employees.add(new Employee("zxb", 500,
                new MyDate(2002,3,9)));

        System.out.println(employees);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1.getName().equals(o2.getName()))) {
                    return o1.getName().compareTo(o2.getName());
                }

                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });

        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        if (year != o.getYear()) {
            return year - o.getYear();
        } else if (month != o.getMonth()) {
            return month - o.getMonth();
        } else {
            return day - o.getDay();
        }
    }
}
