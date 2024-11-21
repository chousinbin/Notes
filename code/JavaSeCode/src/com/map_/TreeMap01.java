package com.map_;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/21 9:13
 * @Description:
 */
public class TreeMap01 {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeMap.put("z", "zxb");
        treeMap.put("zx", "zxk");
        treeMap.put("zxb", "zxb");
        treeMap.put("hsp", "hsp");
        System.out.println(treeMap);
    }
}
