package com.sinbin.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/24 20:07
 * @Description:
 */
public class ThreadState {
    public static void main(String[] args) {
        TS ts = new TS();
        Thread thread = new Thread(ts);

        System.out.println(thread.getState());

        thread.start();

        while (Thread.State.TERMINATED != thread.getState()) {
            System.out.println(thread.getState());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(thread.getState());
    }
}

class TS implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
