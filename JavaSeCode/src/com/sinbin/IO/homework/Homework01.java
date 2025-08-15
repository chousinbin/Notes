package com.sinbin.IO.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/31 11:22
 * @Description:
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("resource\\hm01");
        if (!file1.exists()) {
            file1.mkdirs();
        }

        File file2 = new File("resource\\hm01\\hello.txt");
        if (!file2.exists()) {
            file2.createNewFile();
        } else {
            System.out.println("已存在");
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        bufferedWriter.write("hello,world~");
        bufferedWriter.close();

    }
}
