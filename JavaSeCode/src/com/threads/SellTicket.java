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
        Sell1 sell = new Sell1();
        Thread thread1 = new Thread(sell);
        Thread thread2 = new Thread(sell);
        Thread thread3 = new Thread(sell);
        thread1.start();
        thread2.start();
        thread3.start();

        // fun 2
//        new Sell2().start();
//        new Sell2().start();
//        new Sell2().start();
    }
}

class Sell1 implements Runnable {
    private static int ticketNum = 100;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticketNum == 0) {
                    break;
                }
                --ticketNum;
                System.out.println(Thread.currentThread().getName() + "售票" +
                        "剩余" + ticketNum);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("已售完");
    }
}

class Sell2 extends Thread {
    private static int ticketNum = 100;
    // 锁在静态对象上，确保多个线程对象共享一个锁对象
    private static final Object lock = new Object(); // 锁对象
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (ticketNum == 0) {
                    break;
                }
                --ticketNum;
                System.out.println(Thread.currentThread().getName() + "售票" +
                        "剩余" + ticketNum);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("已售完");
    }
}