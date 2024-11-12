package com.data_;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 16:05
 * @Description:
 */
public class Version3 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
        System.out.println(ldt.getNano());
        System.out.println(ldt.getDayOfWeek());

        // 格式化输出
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分钟ss秒");
        String res = dtf.format(ldt);
        System.out.println(res);
    }
}
