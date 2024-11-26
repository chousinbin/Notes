package com.tank.game;

import java.util.Vector;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 18:07
 * @Description:
 */
public class EnemyTank extends Tank{
    private Vector<Bullet> bullets = new Vector<>();

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
        bullets.add(bullet);
        new Thread(bullet).start();
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public EnemyTank(int x, int y, int direction) {
        super(x, y, direction);
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }
}
