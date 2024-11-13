package com.collection_;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/13 22:19
 * @Description:
 */
public class Collection02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("zxb");
        arrayList.add(22);
        arrayList.add(true);

        Iterator iterator = arrayList.iterator();
        // 迭代器 while 遍历快捷关键词 itit
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 迭代器遍历完不会归零，再次遍历需要重新申请迭代器对象
        iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        // 增强 for 循环
        for (Object obj : arrayList) {
            System.out.println(obj);
        }
    }
}