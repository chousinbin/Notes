package com.sinbin.collection_;

import java.util.*;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/21 11:20
 * @Description:
 * 1)使用HashMap类实例化一个Map类型的对象m,键(String)和值(int)分别用于存储
 * 员的姓名和工资，存入数据如下：
 * jack-650元：tom-1200元：smith-2900元：
 * 2)将jck的工资更改为2600元
 * 3)为所有员工工资加薪100元：
 * 4)遍历集合中所有的员工
 * 5)遍历集合中所有的工资
 */
public class Homework03 {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);

        hashMap.put("jack", 2600);
        System.out.println(hashMap);

        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            hashMap.put(key, (Integer) hashMap.get(key) + 100);
        }
        System.out.println(hashMap);

        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry next =  (Map.Entry) iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());
        }

        Collection values = hashMap.values();
        for (Object obj : values) {
            System.out.println(obj);
        }
    }
}
