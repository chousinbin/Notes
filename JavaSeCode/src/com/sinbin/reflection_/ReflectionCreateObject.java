package com.sinbin.reflection_;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/2/7 22:01
 * @Description:
 */
public class ReflectionCreateObject {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("com.sinbin.reflection_.User");
        // 1. 公有无参构造器
        Object o1 = cls.newInstance();
        System.out.println(o1);
        // 2. 公有有参构造器
        Constructor<?> constructor1 = cls.getConstructor(String.class);
        Object o2 = constructor1.newInstance("zxk");
        System.out.println(o2);
        // 3. 私有有参构造器
        Constructor<?> constructor2 = cls.getDeclaredConstructor(int.class, String.class);
        constructor2.setAccessible(true); // 爆破
        Object o3 = constructor2.newInstance(20, "zxk");
        System.out.println(o3);
    }
}

class User {
    private int age = 10;
    private String name = "zxb";

    public User() {}
    public User(String name) {
        this.name = name;
    }
    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
