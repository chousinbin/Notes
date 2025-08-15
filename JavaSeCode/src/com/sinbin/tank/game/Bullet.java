package com.sinbin.tank.game;

import java.io.Serializable;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/25 22:06
 * @Description: 射击子弹
 */
public class Bullet implements Runnable, Serializable {
    // 子弹横纵坐标
    private int x;
    private int y;
    private int direction = 0;
    private int speed = 2;
    private boolean isLive = true;

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 根据子弹方向移动子弹
            switch (direction) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
//            System.out.println("子弹 " + getX() + ' ' + getY());
            // 子弹到达边界 或者 子弹击中坦克 销毁
            if (!(x >= 0 && x <= 1920 && y >= 0 && y <= 1080) || !this.isLive) {
                isLive = false;
                break;
            }
        }
//        System.out.println("子弹线程结束");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
