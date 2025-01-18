package com.sinbin.IO.trans_stream;

import java.io.*;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/22 13:54
 * @Description:
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("resource\\aa.txt"), "UTF-8");

        osw.write("hello 周新斌");

        osw.close();
    }
}
