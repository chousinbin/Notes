package com.sinbin.IO.trans_stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/22 13:11
 * @Description: 用字符流读取一个非 UTF-8 编码的中文文本文档，而转换流可以在读取字节流的时候 指定编码
 */
public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("resource\\gbk.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); // hello ���±�
        }
        br.close();
    }
}
