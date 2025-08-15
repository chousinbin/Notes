package com.sinbin.threads;

import java.util.Scanner;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/25 16:15
 * @Description: P597
 * 1)在main方法中启动两个线程
 * 2)第1个线程循环随机打印100以内的整数
 * 3)直到第2个线程从键盘读取了“Q”命令。
 */
public class ThreadHomework01 {
    public static void main(String[] args) {
        Prints prints = new Prints();
        Thread thread = new Thread(prints);
        thread.start();

        new Thread(new Listen(prints)).start();
    }
}

class Prints implements Runnable {
    private boolean state = true;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (state) {
            int x = (int)(Math.random() * 100);
            System.out.println(x);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Listen implements Runnable {
    private Prints p;

    public Listen(Prints p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入指令");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                p.setState(false);
                break;
            }
        }
    }
}