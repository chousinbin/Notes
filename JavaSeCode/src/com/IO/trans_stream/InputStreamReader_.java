package com.IO.trans_stream;

import java.io.*;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/22 13:54
 * @Description: 用转换流包装字节流并制定编码，再用 BufferedReader 包装 转换流，批量读取
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(
                new FileInputStream("resource\\gbk.txt"), "GBK");
        BufferedReader bf = new BufferedReader(inputStreamReader);

        String line = bf.readLine();
        System.out.println(line);
        bf.close();
    }
}
