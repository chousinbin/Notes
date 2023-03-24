package com.exception_;

/**
 * @ClassName: ArrayIndexOutOfBounds
 * @Description:
 * @date: 2023-03-24 11:45
 */
public class ArrayIndexOutOfBounds {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3};
        for (int i = 0; i <= arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
