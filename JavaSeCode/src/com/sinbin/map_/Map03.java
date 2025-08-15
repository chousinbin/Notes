package com.sinbin.map_;

import java.util.*;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/16 22:48
 * @Description: 遍历方式
 */
public class Map03 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, "zxb");
        hashMap.put(2, "zxb");
        hashMap.put(3, "zxb");
        // fun 1
        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            Object value = hashMap.get(key);
            System.out.println(key + " " + value);
        }
        // fun 2
        Iterator iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            Object key =  iterator1.next();
            System.out.println(key + " " + hashMap.get(key));
        }
        // fun 3
        Collection values = hashMap.values();
        for (Object value : values) {
            System.out.println(value);
        }
        // fun 4
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value =  iterator2.next();
            System.out.println(value);
        }
        // fun 5
        Set entrySet = hashMap.entrySet();
        for (Object obj : entrySet) {
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // fun 6
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object obj =  iterator3.next();
            System.out.println(obj.getClass());
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
