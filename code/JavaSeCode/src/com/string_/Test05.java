package com.string_;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 21:04
 * @Description: 读程序说出结果，理解内存结构图 ！！！
 */
public class Test05 {
    String str = new String("hsp");
    final char[] ch = { 'j', 'a', 'v', 'a' };

    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'h';
    }

    public static void main(String[] args) {
        Test05 ex = new Test05();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
    }
}
