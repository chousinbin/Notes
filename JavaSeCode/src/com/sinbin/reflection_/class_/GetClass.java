package com.sinbin.reflection_.class_;

import com.sinbin.reflection_.Cat;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/2/7 15:15
 * @Description:
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        Class<?> cls = Class.forName("com.sinbin.reflection_.Cat");
        System.out.println(cls.getClass());

        Class<Cat> cls2 = Cat.class;
        System.out.println(cls2.getClass());

        Cat cat = new Cat();
        Class<? extends Cat> cls3 = cat.getClass();
        System.out.println(cls3);

        ClassLoader cl = cat.getClass().getClassLoader();
        Class<?> cls4 = cl.loadClass("com.sinbin.reflection_.Cat");
        System.out.println(cls4);

        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);
        System.out.println(integerClass.hashCode());

        Class<Integer> type = Integer.TYPE;
        System.out.println(type);
        System.out.println(type.hashCode());

        System.out.println(cls.getPackage());
        System.out.println(cls.getPackage().getName());
        System.out.println(cls.getField("name").getName());
        System.out.println(cls.getField("name").getClass());
        System.out.println(cls.getMethod("cry").getName());
        System.out.println(cls.getMethod("cry").getClass());
    }
}
