package com.sinbin.IO.property;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/31 11:09
 * @Description:
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        System.out.println(properties.setProperty("user", "周新斌"));
        System.out.println(properties.setProperty("user", "新斌"));
        properties.setProperty("pwd", "123321");

        properties.store(new FileWriter("resource\\mysql.properties"), null);

    }
}
