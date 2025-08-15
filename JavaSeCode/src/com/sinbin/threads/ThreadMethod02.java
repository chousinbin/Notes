package com.sinbin.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/24 18:53
 * @Description: P589
 * 案例：创建一个子线程，每隔1s输出hello,输出20
 * 次，主线程每隔1秒，输出hi,输出20次要求：两个线
 * 程同时执行，当主线程输出5次后，就让子线程运行完
 * 毕，主线程再继续，
 */
public class ThreadMethod02 {
    public static void main(String[] args) {
        TTT ttt = new TTT();
        Thread thread = new Thread(ttt);
        thread.start();

        for (int i = 0; i < 20; i++) {
            if (i == 5) {
                try {
                    System.out.println(Thread.currentThread().getName() +
                            " 让出 CPU 给 " + thread.getName());
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(Thread.currentThread().getName() +
                    " hi");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class TTT implements Runnable {
    @Override
    public void run() {
        int cnt = 20;
        while (--cnt >= 0) {
            System.out.println(Thread.currentThread().getName() +
                    " hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}