package com.sinbin.reflection_;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/26 19:25
 * @Description:
 */
public class Case01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("resource\\reflection\\cat.properties"));
        String path = properties.get("path").toString();
        String methodName = properties.get("method").toString();
        String fieldName = properties.get("field").toString();
        // 反射实例化对象
        Class cat = Class.forName(path); // Class 类对象
        Object object = cat.newInstance(); // Cat 类对象
        System.out.println(object.getClass());
        // 反射调用成员方法
        Method method = cat.getMethod(methodName); // Method 类对象，持有配置文件中指定的方法
        method.invoke(object);
        // 反射调用成员变量
        Field name = cat.getField(fieldName);
        System.out.println(name.get(object));
        // 反射调用构造方法
        Constructor constructor1 = cat.getConstructor();
        System.out.println(constructor1);
        Constructor constructor2 = cat.getConstructor(String.class);
        System.out.println(constructor2);
    }
}
