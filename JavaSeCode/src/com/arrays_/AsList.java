package com.arrays_;

import java.util.Arrays;
import java.util.List;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 12:39
 * @Description:
 */
public class AsList {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        List al = Arrays.asList(a);
        al.set(0, 99);
        System.out.println(Arrays.toString(a)); // [99, 2, 3, 4, 5]
    }
}
