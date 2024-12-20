package com.IO;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/27 21:36
 * @Description:
 */
public class FileOutputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void output01() {
        FileOutputStream fileOutputStream = null;
        String path = "D:\\a.txt";

        try {
            fileOutputStream = new FileOutputStream(path);
            // 写入字符
//            fileOutputStream.write('Z');
            // 写入字符串
            String str = "hello, world!";
//            fileOutputStream.write(str.getBytes());
            fileOutputStream.write(str.getBytes(), 0 , str.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void output02() {
        FileOutputStream fileOutputStream = null;
        String path = "D:\\a.txt";

        try {
            // 追加模式
            fileOutputStream = new FileOutputStream(path, true);
            fileOutputStream.write('\n');
            // 写入字符
//            fileOutputStream.write('Z');
            // 写入字符串
            String str = "hello, world!";
//            fileOutputStream.write(str.getBytes());
            fileOutputStream.write(str.getBytes(), 0 , str.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
