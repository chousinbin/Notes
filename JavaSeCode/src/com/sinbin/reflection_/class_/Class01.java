package com.sinbin.reflection_.class_;

import java.lang.reflect.Field;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/2/7 14:18
 * @Description: Class 类常用方法
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classPath = "com.sinbin.reflection_.Cat";
        // <?> 不确定的类型
        Class<?> cls = Class.forName(classPath);
        System.out.println(cls); // 显示Class对象属于哪个类
        System.out.println(cls.getClass()); // Class 对象的运行类型
        // 包名
        String packageName = cls.getPackage().getName();
        System.out.println(packageName);
        // 全类名
        System.out.println(cls.getName());
        // 创建对象实例
        Object o = cls.newInstance();
        System.out.println(o);
        // 得到属性
        Field name = cls.getField("name");
        System.out.println(name.get(o));
        // 给属性赋值
        name.set(o, "小馋猫");
        System.out.println(name.get(o));
        // 得到所有属性
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.get(o));
        }

    }
}
