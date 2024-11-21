package com.generics_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/21 18:46
 * @Description:
 * 1.创建3个学生对象
 * 2.放入到HashSet中.使用.
 * 3.放入到HashMap中，要求 Key String name,Value 就是学生对象
 * 4.使用两种方式遍历
 */
public class Test01 {
    public static void main(String[] args) {
        HashMap<String, Student> hashMap = new HashMap<String, Student>();
        hashMap.put("zxb", new Student("zxb", 22));
        hashMap.put("hsp", new Student("hsp", 50));

        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            System.out.println(key + " " + hashMap.get(key));
        }

        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> entry = iterator.next();
            System.out.println(entry.getKey() + " " +
                    entry.getValue());
        }

        for (Map.Entry<String, Student> entry : entries) {
            System.out.println(entry.getKey() + " " +
                    entry.getValue());
        }

    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
