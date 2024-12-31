package com.IO.property;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/12/31 11:00
 * @Description:
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("resource\\mysql.properties"));
        properties.list(System.out);

        System.out.println(properties.get("user"));
    }
}
