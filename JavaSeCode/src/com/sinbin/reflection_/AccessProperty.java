package com.sinbin.reflection_;

import java.lang.reflect.Field;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/2/7 22:14
 * @Description: 访问属性
 */
public class AccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> cls = Class.forName("com.sinbin.reflection_.Student");
        Object o = cls.newInstance();
        // 公有字段
        Field age = cls.getField("age");
        age.set(o, 22);
        System.out.println(age.get(o));
        // 私有字段
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(null, "zxb");
        System.out.println(name.get(o));
    }
}

class Student {
    public int age;
    private static String name;

    public Student() {}
}
