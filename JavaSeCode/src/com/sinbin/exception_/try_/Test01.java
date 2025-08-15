package com.sinbin.exception_.try_;

/**
 * @ClassName: Test01
 * @Description:
 * @date: 2023-04-02 13:55
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            String str = "123a";
            int num = Integer.parseInt(str);
            System.out.println("!");
        } catch (NumberFormatException e) {
            System.out.println("异常信息:" + e.getMessage());
        }
        System.out.println("结束...");
    }
}
