package com.collection_;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/21 10:10
 * @Description:
 */
public class Collection03 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("123");
        arrayList.add("456");
        arrayList.add("789");
        Collections.reverse(arrayList);
        System.out.println(arrayList);
    }
}
