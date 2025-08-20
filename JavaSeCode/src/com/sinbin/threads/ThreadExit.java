package com.sinbin.threads;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/24 18:27
 * @Description:
 */
public class ThreadExit {
    public static void main(String[] args) {
        T t = new T();
        Thread thread = new Thread(t);
        thread.start();
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // 通知线程结束
        t.setLoop(false);
    }
}

class T implements Runnable {
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
