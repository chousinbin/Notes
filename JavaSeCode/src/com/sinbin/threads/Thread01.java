package com.sinbin.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 19:44
 * @Description:
 */
public class Thread01{
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        /*
            1. 调用 start 方法，启动一个新线程
            public synchronized void start() {
                start0();
            }

            2. 底层是 start() 本地方法，由 JVM 调用，底层由 C/C++ 实现
            private native void start0();
         */
        cat1.start();

//        for (int i = 0; i < 40; i++) {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}

class Cat extends Thread {
    @Override
    public void run() {
        int times = 80;
        while (-- times >= 0) {
            System.out.println("Hello~" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
