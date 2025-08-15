package com.sinbin.system_;

import java.util.Arrays;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 14:10
 * @Description:
 */
public class ArrayCopy {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = new int[3]; // {0, 0, 0}

        System.arraycopy(a, 0, b, 1, 2);

        System.out.println(Arrays.toString(b));

        System.out.println(System.currentTimeMillis());
    }
}
