package com.sinbin.map_;

import java.util.Properties;
@SuppressWarnings({"all"})
/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/20 21:18
 * @Description:
 */
public class Properties01 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("zxb", "22");
        properties.put("zxk", "16");
        properties.put("zfh", "45");
        properties.put("hly", "45");

        System.out.println(properties);
    }
}
