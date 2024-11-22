package com.data_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 14:43
 * @Description:
 */
public class Exec01 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");

        String res = sdf.format(date);
        System.out.println(res);

        String s = "2024年11月12日 02:57:34 星期二";
        Date d2 = sdf.parse(s);
        System.out.println(d2);
    }
}
