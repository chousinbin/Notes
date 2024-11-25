package com.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/25 17:17
 * @Description: P598
 */
public class ThreadHomework02 {
    public static void main(String[] args) {
        Card card = new Card();
        new Thread(card).start();
        new Thread(card).start();
    }
}

class Card implements Runnable {
    private static int balance = 10000;
    private static final Object lock = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (balance < 1000) {
                    break;
                }
                balance -= 1000;
                System.out.println(Thread.currentThread().getName() +
                        " 取出 1000 元 剩余 " +
                        balance);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("余额不足");
    }
}