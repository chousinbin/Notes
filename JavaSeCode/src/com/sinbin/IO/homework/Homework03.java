package com.sinbin.IO.homework;

import java.io.*;
import java.util.Properties;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/31 11:42
 * @Description:
 */
public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader("resource\\dog.properties"));
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        String color = properties.getProperty("color");

        Dog dog = new Dog(name, Integer.parseInt(age), color);
        System.out.println(dog);

        // 序列化对象
        String path = "resource\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(dog);
        oos.close();
        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Dog dog2 = (Dog)ois.readObject();
        System.out.println(dog2);
    }


}

class Dog implements Serializable{
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
