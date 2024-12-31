package com.IO.buffered;

import java.io.*;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/21 18:24
 * @Description:
 */
public class BufferedCopy02 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("resource\\水浒传001.wma"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream("resource\\水浒传001_copy.wma"));

        byte buffer[] = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, len);
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
