package com.data_;

import java.util.Calendar;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 15:40
 * @Description:
 */
public class Calendar_ {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        System.out.println(c);

        System.out.println(c.get(Calendar.DATE));
        System.out.println(c.get(Calendar.YEAR) + 1); // 月默认从 0 开始
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.get(Calendar.SECOND));
    }
}
