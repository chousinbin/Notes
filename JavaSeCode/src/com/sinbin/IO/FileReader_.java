package com.sinbin.IO;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/20 21:35
 * @Description:
 */
public class FileReader_ {
    public static void main(String[] args) {
        readBySingleChar();
        System.out.println();
        readByMultiChar();
    }

    private static void readByMultiChar() {
        String filePath = "resource\\a.txt";
        FileReader fileReader = null;

        char data[] = new char[8];
        int len;

        try {
            fileReader = new FileReader(filePath);
            while ((len = fileReader.read(data)) != -1) {
                // 字符数组转 String
                System.out.print(new String(data, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void readBySingleChar() {
        String filePath = "D:\\a.txt";
        FileReader fileReader = null;
        int data;
        try {
            fileReader = new FileReader(filePath);
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
