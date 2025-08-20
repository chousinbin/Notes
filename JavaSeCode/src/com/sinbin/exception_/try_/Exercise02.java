package com.sinbin.exception_.try_;

import java.util.Scanner;

/**
 * @ClassName: Exercise02
 * @UserName: SinBin
 * @date: 2023-04-02 15:33
 * @Description:
 * 要求:输入整数, 如果不是整数重复输入,直到输入的为整数
 */
public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;

        while (true) {
            System.out.print("请输入一个整数:");
            try {
                num = Integer.parseInt(scanner.next());  //可能出现异常
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是整数!");
            }
        }

        System.out.println(num);
    }
}
