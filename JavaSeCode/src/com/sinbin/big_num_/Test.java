package com.sinbin.big_num_;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/12 14:19
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        BigInteger bigInteger01 = new BigInteger("1231231233234123123");
        BigInteger bigInteger02 = new BigInteger("333333333333333");
        System.out.println(bigInteger01.add(new BigInteger("1")));


        BigDecimal bigDecimal01 = new BigDecimal("123123123123123123123123.11");
        BigDecimal bigDecimal02 = new BigDecimal("3");
        BigDecimal res = bigDecimal01.divide(bigDecimal02, BigDecimal.ROUND_CEILING);
        System.out.println(res);
    }
}
