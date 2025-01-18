package com.sinbin.IO.print_stream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/22 14:12
 * @Description:
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        // 默认输出位置是显示器
        out.println("hello, 周新斌");
        // print 底层是 write
        out.write("你好".getBytes());
        // 修改输出位置
        System.setOut(new PrintStream("resource\\ps.txt"));
        System.out.println("加瓦");
    }
}
