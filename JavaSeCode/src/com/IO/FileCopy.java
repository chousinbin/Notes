package com.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/20 21:14
 * @Description: 文件拷贝：每读取一部分就写入一部分实现
 */
public class FileCopy {
    public static void main(String[] args) {
        String filePath = "D:\\logo.jpg";
        String destPath = "D:\\new\\logo.jpg";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;


        try {
            fileInputStream = new FileInputStream(filePath);
            fileOutputStream = new FileOutputStream(destPath);

            byte[] buffer = new byte[1024];
            int len = 0;

            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
                /**
                 * fileOutputStream.write(buffer);
                 * 这种写法不安全
                 */
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
