package com.sinbin.tank.game;

import java.util.Vector;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 18:07
 * @Description:
 */
public class EnemyTank extends Tank implements Runnable {
    private Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank() {}

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public EnemyTank(int x, int y, int direction) {
        super(x, y, direction);
    }

    @Override
    public void run() {
        while (true) {
            // 死亡之后不再移动和发射
            if (!this.isLive()) {
                break;
            }

            switch (this.getDirection()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (!isCrash()) {
                            moveUp();
                        }
                        sleep(50);
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (!isCrash()) {
                            moveRight();
                        }
                        sleep(50);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (!isCrash()) {
                            moveDown();
                        }
                        sleep(50);
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (!isCrash()) {
                            moveLeft();
                        }
                        sleep(50);
                    }
                    break;
            }

            this.setDirection((int) (Math.random() * 4));

            if (isLive() && this.getBullets().isEmpty()) {
                fire();
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

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    // 判断当前 enemyTank 是否与其他 enemyTanks 发生碰撞
    // TODO: 由于位置固定位左上角，导致旋转之后出现重叠
    boolean isCrash() {
        for (int i = 0; i <enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (this == enemyTank) {
                continue;
            }

            // 确定敌人坦克的范围
            int enemyTankLeft = enemyTank.getX();
            int enemyTankRight = enemyTank.getX() + (enemyTank.getDirection() % 2 == 1 ? 60 : 40);
            int enemyTankTop = enemyTank.getY();
            int enemyTankBottom = enemyTank.getY() + (enemyTank.getDirection() % 2 == 1 ? 40 : 60);

            switch (this.getDirection()) {
                case 0:
                    // 左上角与敌人坦克碰撞
                    if (this.getX() >= enemyTankLeft &&
                            this.getX() <= enemyTankRight &&
                            this.getY() >= enemyTankTop &&
                            this.getY() <= enemyTankBottom) {
                        return true;
                    }
                    // 右上角与敌人坦克碰撞
                    if (this.getX() + 40 >= enemyTankLeft &&
                            this.getX() + 40 <= enemyTankRight &&
                            this.getY() >= enemyTankTop &&
                            this.getY() <= enemyTankBottom) {
                        return true;
                    }
                    break;
                case 1:
                    // 右上角与敌人坦克碰撞
                    if (this.getX() + 60 >= enemyTankLeft &&
                            this.getX() + 60 <= enemyTankRight &&
                            this.getY() >= enemyTankTop &&
                            this.getY() <= enemyTankBottom) {
                        return true;
                    }
                    // 右下角与敌人坦克碰撞
                    if (this.getX() + 60 >= enemyTankLeft &&
                            this.getX() + 60 <= enemyTankRight &&
                            this.getY() + 40 >= enemyTankTop &&
                            this.getY() + 40 <= enemyTankBottom) {
                        return true;
                    }
                    break;
                case 2:
                    // 左下角与敌人坦克碰撞
                    if (this.getX() >= enemyTankLeft &&
                            this.getX() <= enemyTankRight &&
                            this.getY() + 60 >= enemyTankTop &&
                            this.getY() + 60 <= enemyTankBottom) {
                        return true;
                    }
                    // 右下角与敌人坦克碰撞
                    if (this.getX() + 40 >= enemyTankLeft &&
                            this.getX() + 40 <= enemyTankRight &&
                            this.getY() + 60 >= enemyTankTop &&
                            this.getY() + 60 <= enemyTankBottom) {
                        return true;
                    }
                    break;
                case 3:
                    // 左下角与敌人坦克碰撞
                    if (this.getX() >= enemyTankLeft &&
                            this.getX() <= enemyTankRight &&
                            this.getY() + 40 >= enemyTankTop &&
                            this.getY() + 40 <= enemyTankBottom) {
                        return true;
                    }
                    // 左上角与敌人坦克碰撞
                    if (this.getX() >= enemyTankLeft &&
                            this.getX() <= enemyTankRight &&
                            this.getY() >= enemyTankTop &&
                            this.getY() <= enemyTankBottom) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
