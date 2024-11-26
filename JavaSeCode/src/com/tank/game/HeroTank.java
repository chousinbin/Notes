package com.tank.game;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 13:05
 * @Description:
 */
public class HeroTank extends Tank{
    public HeroTank(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {
        if (getBullets().size() >= 3) {
            return;
        }
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
        // 限制攻速
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - getLastShotTime() > Tank.FIRE_INTERVAL) {
            Bullet bullet = new Bullet(shotX, shotY, this.getDirection());
            new Thread(bullet).start();
            this.getBullets().add(bullet);
            this.setLastShotTime(currentTimeMillis);
        }

//        System.out.println("子弹发射");
    }
}
