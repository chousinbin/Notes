package com.sinbin.IO.homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/31 11:34
 * @Description:
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("resource\\hm02.txt"));

        String line;
        int cnt = 0;
        while ((line = br.readLine()) != null) {
            line = ++cnt + " " + line;
            System.out.println(line);
        }

        br.close();
    }
}
