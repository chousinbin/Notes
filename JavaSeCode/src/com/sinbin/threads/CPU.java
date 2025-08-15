package com.sinbin.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 19:36
 * @Description:
 */
public class CPU {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int threads = runtime.availableProcessors();
        System.out.println("当前逻辑核心数 " + threads);
    }
}
