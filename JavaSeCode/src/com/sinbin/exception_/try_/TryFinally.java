package com.sinbin.exception_.try_;

/**
 * @ClassName: TryFinally
 * @UserName: SinBin
 * @date: 2023-04-02 14:52
 * @Description:
 */
public class TryFinally {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } finally {
            System.out.println("总是执行");
        }
    }
}
