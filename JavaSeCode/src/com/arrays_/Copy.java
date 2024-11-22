package com.arrays_;

import java.util.Arrays;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 12:28
 * @Description:
 */
public class Copy {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        int[] b = Arrays.copyOf(a, 3);

        System.out.println(Arrays.toString(b));

        Arrays.fill(a, 99);

        System.out.println(Arrays.toString(a));

    }
}
