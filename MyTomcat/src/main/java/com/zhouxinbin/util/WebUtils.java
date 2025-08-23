package com.zhouxinbin.util;

public class WebUtils {
    public static int parseInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(str + "转换失败");
        }
        return defaultValue;
    }
}
