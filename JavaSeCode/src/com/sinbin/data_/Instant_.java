package com.sinbin.data_;

import java.time.Instant;
import java.util.Date;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 16:26
 * @Description:
 */
public class Instant_ {
    public static void main(String[] args) {
        // 获取时间戳
        Instant instant = Instant.now();
        System.out.println(instant);
        // 时间戳 2 Date
        Date date = Date.from(instant);
        System.out.println(date);
        // Date 2 时间戳
        Instant instant1 = date.toInstant();
        System.out.println(instant1);
    }
}
