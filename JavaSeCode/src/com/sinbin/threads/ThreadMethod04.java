package com.sinbin.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/24 19:48
 * @Description: P591
 */
public class ThreadMethod04 {
    public static void main(String[] args) {
        T4 t4 = new T4();
        Thread thread = new Thread(t4);
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class T4 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("hi");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
