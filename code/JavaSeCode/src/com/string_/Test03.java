package com.string_;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 19:34
 * @Description: 编写java程序，输入形式为：Han Shun Pingl的人名，以Ping,Han.S的形式打印
 * 出来。其中S是中间单词的首字母。
 * 例如输入"Willian Jefferson Clinton”，输出形式为：(Clinton,Willian .J）
 */
public class Test03 {
    public static void main(String[] args) {
        try {
            String res = printName("Zhou Xin Bin");
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String printName(String s) {
        if (s == null) {
            throw new RuntimeException("字符串输入不能为空");
        }

        String[] sp = s.split(" ");
        if (sp.length != 3) {
            throw new RuntimeException("字符串输入格式有误");
        }

        return String.format("%s, %s. %c", sp[2], sp[0], sp[1].toUpperCase().charAt(0));
    }
}
