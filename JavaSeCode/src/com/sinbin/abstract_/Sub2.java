package com.sinbin.abstract_;

/**
 * @ClassName: Sub2
 * @Description:
 * @date: 2023-03-09 17:52
 */
public class Sub2 extends Template{
    public void job() {
        long sum = 0;
        for (int i = 1; i < 100000; i++) {
            sum *= i;
        }
        System.out.print("Sub2.job()");
    }
}
