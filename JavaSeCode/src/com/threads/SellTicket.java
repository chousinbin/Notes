package com.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/24 17:33
 * @Description: P586 P593
 * 两种方法都会超卖
 * 加上 synchronized 就不会超卖
 */
public class SellTicket {
    public static void main(String[] args) {
//        // fun 1
//        Sell1 sell = new Sell1();
//        Thread thread1 = new Thread(sell);
//        Thread thread2 = new Thread(sell);
//        Thread thread3 = new Thread(sell);
//        thread1.start();
//        thread2.start();
//        thread3.start();

        // fun 2
        new Sell2().start();
        new Sell2().start();
        new Sell2().start();
    }
}

class Sell1 implements Runnable {
    private static int ticketNum = 100;
    @Override
    public synchronized void run() {
        while (--ticketNum >= 0) {
            System.out.println(Thread.currentThread().getName() + "售票" +
                    "剩余" + ticketNum);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("已售完");
    }
}

class Sell2 extends Thread {
    private static int ticketNum = 100;
    private static final Object lock = new Object(); // 锁对象
    // 同步应该锁在临界资源上，run 方法是线程对象
    @Override
    public void run() {
        synchronized (lock) {
            while (--ticketNum >= 0) {
                System.out.println(Thread.currentThread().getName() + "售票" +
                        "剩余" + ticketNum);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("已售完");
    }
}