package com.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/20 21:59
 * @Description:
 */
public class FileWriter_ {
    public static void main(String[] args) {
        writeBySingleChar();
        writeByCharArray();
        writeByString();
    }

    private static void writeByCharArray() {
        String filePath = "resource\\b.txt";
        FileWriter fileWriter = null;
        File file = null;

        char[] chars = {'z', 'x', 'b'};

        try {
            // 文件创建
            file = new File(filePath);
            file.createNewFile();
            // 文件写入
            fileWriter = new FileWriter(filePath);
            // 写入单个字符
            fileWriter.write(chars);
            fileWriter.write(chars, 0, 2);
            fileWriter.write("我是周新斌");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // FileWriter 必须关闭对象，否则无法写入
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void writeBySingleChar() {
        String filePath = "resource\\b.txt";
        FileWriter fileWriter = null;
        File file = null;

        try {
            // 文件创建
            file = new File(filePath);
            file.createNewFile();
            // 文件写入
            fileWriter = new FileWriter(filePath);
            // 写入单个字符
            fileWriter.write('Z');
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // FileWriter 必须关闭对象，否则无法写入
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void writeByString() {
        String filePath = "resource\\b.txt";
        FileWriter fileWriter = null;
        File file = null;

        try {
            // 文件创建
            file = new File(filePath);
            file.createNewFile();
            // 文件写入
            fileWriter = new FileWriter(filePath);
            // 写入单个字符
            fileWriter.write("我是周新斌");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // FileWriter 必须关闭对象，否则无法写入
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
