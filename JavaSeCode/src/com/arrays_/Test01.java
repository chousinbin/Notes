package com.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 11:13
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        Integer[] a = {1, 3, 2, 5, 4};

        System.out.println(Arrays.toString(a));

        Arrays.sort(a);

        System.out.println(Arrays.toString(a));

        // 降序
        Arrays.sort(a, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int)o2 - (int)o1;
            }
        });

        System.out.println(Arrays.toString(a));
    }
}
