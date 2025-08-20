package com.sinbin.IO;

import java.io.File;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/26 22:06
 * @Description: P611
 */
public class FileCreate {
    public static void main(String[] args) {
        fun1();
        fun2();
        fun3();
    }
    // 完整路径
    public static void fun1() {
        String filePath = "resource\\file1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // 父路径对象化，可以方便灵活修改父路径
    public static void fun2() {
        File parentPath = new File("resource");
        String fileName = "file2.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // 相对路径
    public static void fun3() {
        String parentPath = "resource";
        String name = "file3.txt";
        File file = new File(parentPath, name);
        System.out.println(file.exists());
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(file.exists());
    }
}
