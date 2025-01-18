package com.sinbin.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 12:01
 * @Description: 用接口实现自定义排序
 */
public class DiySortAndComparator {
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4};

        bubbleSort(a, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer)o1;
                int i2 = (Integer)o2;
//                return i1 - i2;
                return i2 - i1;
            }
        });

        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] a, Comparator c) {
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (c.compare(a[i], a[j]) > 0) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
