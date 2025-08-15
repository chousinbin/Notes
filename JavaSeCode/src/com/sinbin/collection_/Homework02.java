package com.sinbin.collection_;

import java.util.ArrayList;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/21 11:18
 * @Description:
 * 使用ArrayList完成对对象Car{name,price}的各种操作
 * 1.add:添加单个元素
 * 2.remove:删除指定元素
 * 3.contains:查找元素是否存在
 * 4.size获取元素个数
 * 5.isEmpty:判断是否为空
 * 6.clear::清空
 * 7.addAll:添加多个元素
 * 8.containsAll::查找多个元素是否都存在
 * 9.removeAll::删除多个元素
 * 使用增强for和迭代器来遍历所有的car,需要重写Car的toString方法
 */
public class Homework02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Car car1 = new Car("GRS184", 30000);
        Car car2 = new Car("LS430", 40000);
        Car car3 = new Car("REIZ", 20000);

        arrayList.add(car1);
        arrayList.add(car2);
        arrayList.add(car3);
        System.out.println(arrayList);

        arrayList.remove(car1);
        System.out.println(arrayList);

        arrayList.addAll(arrayList);
        System.out.println(arrayList);


    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
