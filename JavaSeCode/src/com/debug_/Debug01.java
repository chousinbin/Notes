package com.debug_;

import com.arrays_.AsList;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/14 15:38
 * @Description:
 */
public class Debug01 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            fun(i);
        }
    }

    public static void fun(int x) {
        System.out.println(x);
    }
}
