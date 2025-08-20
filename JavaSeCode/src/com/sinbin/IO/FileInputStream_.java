package com.sinbin.IO;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/27 21:09
 * @Description:
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void read01() {
        String path = "D:\\hello.txt";
        FileInputStream fileInputStream = null;
        int readDate = 0;
        try {
            fileInputStream = new FileInputStream(path);
            while ((readDate = fileInputStream.read()) != -1) {
                System.out.print((char)readDate);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void read02() {
        String path = "D:\\hello.txt";
        FileInputStream fileInputStream = null;
        int byteCount = 0;
        byte[] buffer = new byte[8];
        try {
            fileInputStream = new FileInputStream(path);
            while ((byteCount = fileInputStream.read(buffer)) != -1) {
                System.out.println(byteCount);
                System.out.print(new String(buffer, 0, byteCount));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
