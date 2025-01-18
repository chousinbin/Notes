package com.sinbin.IO.standard;

import java.util.Scanner;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/21 20:33
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(System.in.getClass());
        System.out.println(System.out.getClass());

        Scanner scanner = new Scanner(System.in);
        String res = scanner.next();
        System.out.println(res);
    }
}
