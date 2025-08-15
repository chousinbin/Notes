package com.sinbin.hashset_;

import java.util.Comparator;
import java.util.TreeSet;
@SuppressWarnings({"all"})
/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/20 21:45
 * @Description:
 */
public class TreeSet01 {
    public static void main(String[] args) {

        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2);
            }
        });
        
        treeSet.add("tom");
        treeSet.add("jerry");
        treeSet.add("hsp");
        treeSet.add("zxb");
        System.out.println(treeSet);

    }
}
