package com.IO.print_stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/22 14:19
 * @Description:
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.write("大连");

        printWriter = new PrintWriter(new FileWriter("resource\\pw.txt"));
        printWriter.write("打印字符流");

        printWriter.close();
    }
}
