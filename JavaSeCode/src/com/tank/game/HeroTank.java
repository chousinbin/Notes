package com.tank.game;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 13:05
 * @Description:
 */
public class HeroTank extends Tank{
    private Bullet bullet = null;
    public HeroTank(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {
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

        bullet = new Bullet(shotX, shotY, this.getDirection());
        new Thread(bullet).start();
//        System.out.println("子弹发射");
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
}
