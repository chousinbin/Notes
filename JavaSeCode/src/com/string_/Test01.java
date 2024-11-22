package com.string_;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 18:35
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        // 编写区间翻转方法
        String s = "ABCDEFG";
        // 异常处理
        try {
            s = reverse(s, 0, s.length() - 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(s);
    }

    public static String reverse(String s, int begin, int end) {
        // 判断条件
        if (!(s != null && begin >= 0 && begin < end && end < s.length())) {
            throw new RuntimeException("参数不正确");
        }

        char[] ch = s.toCharArray();
        char temp = ' ';

        for (int i = begin, j = end; i < j; i ++, j --) {
            temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }

        return new String(ch);
    }
}
