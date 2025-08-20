package com.sinbin.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/24 18:43
 * @Description: P588
 */
public class ThreadMethod01 {
    public static void main(String[] args) {
        TT tt = new TT();
        Thread thread = new Thread(tt);
        thread.start();

        thread.setName("zxb");
        System.out.println(thread.getName());

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("主方法");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        thread.interrupt();
    }
}

class TT implements Runnable {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                System.out.println("线程启动" + i);
            }
            try {
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {
                System.out.println("休眠被中断");
            }
        }
    }
}
