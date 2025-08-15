package com.sinbin.IO.buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/21 14:49
 * @Description:
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String path = "resource\\a.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        bufferedWriter.write("hello");
        bufferedWriter.newLine();
        bufferedWriter.write("周新斌");
        bufferedWriter.close();
    }
}
