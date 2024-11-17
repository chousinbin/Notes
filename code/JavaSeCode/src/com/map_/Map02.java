package com.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
@SuppressWarnings({"all"})
/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/16 21:58
 * @Description: 展示 HashMap 提供的集合
 */
public class Map02 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, "zxb");
        hashMap.put(2, "zxb");
        hashMap.put(3, "zxb");
        // 键值对集合
        Set entrySet = hashMap.entrySet();
        System.out.println(entrySet.getClass());
        // Key 集合
        Set keySet = hashMap.keySet();
        System.out.println(keySet.getClass());
        // Value 集合
        Collection valueSet = hashMap.values();
        System.out.println(valueSet.getClass());
    }
}
