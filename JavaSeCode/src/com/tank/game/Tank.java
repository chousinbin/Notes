package com.tank.game;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/22 20:20
 * @Description:
 */
public class Tank {
    // 坦克的坐标，指坦克左上角
    private int x;
    private int y;
    private int direction;
    private int speed = 1;
    private boolean isLive = true;

    public void moveUp() {
        y = y - speed >= 0 ? y - speed :  y;
    }

    public void moveRight() {
        x = x + speed + 60 <= 1920 ? x + speed : x;
    }

    public void moveDown() {
        y = y + speed + 60 <= 1080 ? y + speed :  y;
    }

    public void moveLeft() {
        x = x - speed >= 0 ? x - speed : x;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tank(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }
}
