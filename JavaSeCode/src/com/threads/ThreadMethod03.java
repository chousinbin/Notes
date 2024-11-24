package com.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/24 19:14
 * @Description: P590
 * 1.主线程每隔1s, 输出h, 一共10次
 * 2.当输出到hi5时，启动一个子线程（要求
 * 实现Runnable),每隔1s输出hello,等
 * 该线程输出10次hello后，退出
 * 3.主线程继续输出hi,直到主线程退出.
 * 4.如图，完成代码
 */
public class ThreadMethod03 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                T3 t3 = new T3();
                Thread thread = new Thread(t3);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("hi");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("主线程结束");
    }
}

class T3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("子线程结束");
    }
}
