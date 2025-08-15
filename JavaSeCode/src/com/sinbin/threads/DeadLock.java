package com.sinbin.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/25 15:56
 * @Description: P595 模拟死锁
 */
public class DeadLock {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Lock(true));
        Thread thread2 = new Thread(new Lock(false));

        thread1.start();
        thread2.start();
    }
}

class Lock implements Runnable {
    private boolean flag;
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    public Lock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() +
                        " 进入 1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() +
                            " 进入 2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() +
                        " 进入 3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() +
                            " 进入 4");
                }
            }
        }
    }
}