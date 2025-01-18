package com.sinbin.IO.decorators;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/21 14:11
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        new BufferedReader_(new FileReader_()).read(2);
        new BufferedReader_(new StringReader_()).read(2);

        new BufferedReader_(new FileReader_()).read();
    }
}
