package com.sinbin.list_;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({"all"})
/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/14 12:30
 * @Description:
 */
public class List01 {

    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
//        System.out.println(arrayList.indexOf("1"));
//        System.out.println(arrayList.lastIndexOf("1"));

        System.out.println(arrayList.set(1, "0"));

        List list2 = arrayList.subList(0, 2);
        System.out.println(list2);
    }
}
