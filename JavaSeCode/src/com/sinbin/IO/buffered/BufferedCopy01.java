package com.sinbin.IO.buffered;

import java.io.*;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/21 14:58
 * @Description:
 */
public class BufferedCopy01 {
    public static void main(String[] args) throws IOException {
        String originalPath = "resource\\a.txt";
        String destPath = "resource\\a_copy.txt";

        BufferedReader br = new BufferedReader(new FileReader(originalPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
