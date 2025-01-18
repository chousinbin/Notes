package com.sinbin.test;
import java.util.Scanner;

/**
 * @ClassName: Add
 * @UserName: SinBin
 * @date: 2023-06-25 20:08
 * @Description:
 */
public class Add {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int x1;
        int x2;
        x1 = myScanner.nextInt();
        x2 = myScanner.nextInt();

        int sum = 0;
        int i;

        for (i = 0; sum < x1; i++) {
            sum += x2;
        }
        sum -= x2;
        i--;

        System.out.println(i);
        System.out.println(x1 - sum);
    }
}
