package com.exception_.runningexception;

/**
 * @ClassName: NumberFormatException
 * @Description:
 * @date: 2023-03-24 11:54
 */
public class NumberFormatException {
    public static void main(String[] args) {
        String name = "1234";
        int num = Integer.parseInt(name);
        name = "zhou";
        num = Integer.parseInt(name);
    }
}
