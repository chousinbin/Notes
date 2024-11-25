package com.tank.game;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 13:05
 * @Description:
 */
public class MyTank extends Tank{
    private Shot shot = null;
    public MyTank(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {
        int shotX = 0;
        int shotY = 0;

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

        shot = new Shot(shotX, shotY, this.getDirection());
        Thread thread = new Thread(shot);
        thread.start();
//        System.out.println("子弹发射");
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }
}
