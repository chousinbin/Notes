package com.tank.game;

import java.util.Vector;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 18:07
 * @Description:
 */
public class EnemyTank extends Tank implements Runnable{
    public void shotHeroTank() {
        int shotX = this.getX();
        int shotY = this.getY();

        switch (this.getDirection()) {
            case 0:
                shotX = this.getX() + 20;
                break;
            case 1:
                shotX = this.getX() + 60;
                shotY = this.getY() + 20;
                break;
            case 2:
                shotX = this.getX() + 20;
                shotY = this.getY() + 60;
                break;
            case 3:
                shotY = this.getY() + 20;
                break;
        }

        Bullet bullet = new Bullet(shotX, shotY, this.getDirection());
        this.getBullets().add(bullet);
        new Thread(bullet).start();
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public EnemyTank(int x, int y, int direction) {
        super(x, y, direction);
    }

    @Override
    public void run() {
        while (true) {
            switch (this.getDirection()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        moveUp();
                        sleep(50);
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        moveRight();
                        sleep(50);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        moveDown();
                        sleep(50);
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        moveLeft();
                        sleep(50);
                    }
                    break;
            }

            this.setDirection((int)(Math.random() * 4));

            if (!this.isLive()) {
                break;
            }
        }
    }

    private void sleep(int s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
