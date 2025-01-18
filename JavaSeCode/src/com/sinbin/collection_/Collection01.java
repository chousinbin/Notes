package com.sinbin.collection_;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/13 21:45
 * @Description:
 */
public class Collection01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        System.out.println(arrayList.add("zxb"));
        arrayList.add(22);
        arrayList.add(true);
        arrayList.add(true);
        System.out.println(arrayList);

        arrayList.remove(true);
        System.out.println(arrayList);
    }
}
