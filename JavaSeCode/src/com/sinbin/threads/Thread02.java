package com.sinbin.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 20:24
 * @Description:
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // 代理设计模式
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable {
    @Override
    public void run() {
        int cnt = 0;
        while (cnt ++ < 6) {
            System.out.println("汪~" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}