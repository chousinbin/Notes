package com.sinbin.IO.buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/21 14:32
 * @Description:
 */
public class BufferedReader_ {
    public static void main(String[] args) throws IOException{
        String path = "resource\\b.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
