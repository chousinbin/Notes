package com.sinbin.reflection_;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/2/7 22:22
 * @Description:
 */
public class InvokeMethods {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("com.sinbin.reflection_.Dog");
        Object o = cls.newInstance();

        cls.getMethod("hi").invoke(null);

        Method cry = cls.getDeclaredMethod("cry", String.class);
        cry.setAccessible(true);
        cry.invoke(o, "旺旺");
    }
}

class Dog {
    public static void hi() {
        System.out.println("你好");
    }

    private void cry(String name) {
        System.out.println("汪汪 " + name);
    }
}
