package com.sinbin.reflection_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/26 20:49
 * @Description: 测试反射性能
 */
public class Case02 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        m1();
        m2();
        m3();
    }
    // 直接 new 对象
    public static void m1() {
        Cat cat = new Cat();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1e9; i++) {
            cat.hi();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
    // 反射调用
    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("com.sinbin.reflection_.Cat");
        Object o = cls.newInstance();
        Method method = cls.getMethod("hi");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1e9; i++) {
            method.invoke(o);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
    // 反射调用优化
    public static void m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("com.sinbin.reflection_.Cat");
        Object o = cls.newInstance();
        Method method = cls.getMethod("hi");
        method.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1e9; i++) {
            method.invoke(o);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
