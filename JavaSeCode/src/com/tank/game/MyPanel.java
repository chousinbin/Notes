package com.tank.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 13:06
 * @Description: 游戏面板
 */
public class MyPanel extends JPanel implements KeyListener, Runnable{
    HeroTank hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankInitialSize = 3;
    Vector<Bomb> bombs = new Vector<>();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    public MyPanel() {
        hero = new HeroTank(800, 500);
        hero.setSpeed(2);
        for (int i = 0; i < enemyTankInitialSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            new Thread(enemyTank).start();
            enemyTank.setDirection(2);
            // 敌人创建一个子弹
            enemyTank.fire();
            enemyTanks.add(enemyTank);
        }
        // 初始化图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 默认黑色绘制地图
        g.fillRect(0, 0, 1904, 1041);
        // 绘制自己的坦克
        if (hero.isLive()) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);
        }
        // 绘制自己子弹
        for (int i = 0; i < hero.getBullets().size(); i++) {
            Bullet bullet = hero.getBullets().get(i);
            if (bullet.getIsLive()) {
                g.setColor(Color.cyan);
                g.fillOval(bullet.getX(), bullet.getY(), 4, 4);
            } else {
                hero.getBullets().remove(bullet);
            }
        }
        // 绘制敌人的坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g,
                        enemyTank.getDirection(), 0);
            }
            // 绘制敌人坦克的所有子弹
            for (int j = 0; j < enemyTank.getBullets().size(); j ++) {
                g.setColor(Color.yellow);
                Bullet bullet = enemyTank.getBullets().get(j);
                if (bullet.getIsLive()) {
                    g.fillOval(bullet.getX(), bullet.getY(), 4, 4);
                } else {
                    enemyTank.getBullets().remove(bullet);
                }
            }
        }

        // 绘制炸弹
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.getLife() > 6) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 3) {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            } else {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            bomb.lifeDown();
            if (bomb.getLife() == 0) {
                bombs.remove(bomb);
            }
        }
    }

    public void drawTank(int x, int y, Graphics g, int direction, int type) {
        // 坦克类型
        switch (type) {
            // 自己
            case 0:
                g.setColor(Color.yellow);
                break;
            // 敌人
            case 1:
                g.setColor(Color.cyan);
                break;
        }
        // 坦克方向
        switch (direction) {
            // 向上
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            // 向右
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            // 向下
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            // 向左
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    public void checkHit(Bullet bullet, Tank tank) {
        int xMin = tank.getX();
        int yMin = tank.getY();
        int xMax = xMin;
        int yMax = yMin;

        switch (tank.getDirection()) {
            case 0:
            case 2:
                xMax = tank.getX() + 40;
                yMax = tank.getY() + 60;
                break;
            case 1:
            case 3:
                xMax = tank.getX() + 60;
                yMax = tank.getY() + 40;
                break;
        }

        if (bullet.getX() >= xMin && bullet.getX() <= xMax &&
                bullet.getY() >= yMin && bullet.getY() <= yMax) {
            bullet.setLive(false);
            tank.setLive(false);
            /*
                移除被击中的敌人坦克，会导致敌人遗留的子弹同步被销毁
                不如在线程 run 中事先判断敌人坦克是否存活
             */
//            enemyTanks.remove(enemyTank);
            // 击中爆炸
            Bomb bomb = new Bomb(tank.getX(), tank.getY());
            bombs.add(bomb);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirection(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(3);
            hero.moveLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.fire();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 重绘游戏面板
            this.repaint();
            // 检查我方是否击中敌人坦克
            for (int i = 0; i < hero.getBullets().size(); i++) {
                Bullet bullet = hero.getBullets().get(i);
                if (bullet != null && bullet.getIsLive()) {
                    for (int j = 0; j < enemyTanks.size(); j++) {
                        if (enemyTanks.get(j).isLive()) {
                            checkHit(bullet, enemyTanks.get(j));
                        }
                    }
                }
            }
            // 检查敌方是否击中我方坦克
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                Vector<Bullet> bullets = enemyTank.getBullets();
                for (int j = 0; j < bullets.size(); j++) {
                    Bullet bullet = bullets.get(j);
                    if (hero.isLive()) {
                        checkHit(bullet, hero);
                    }
                }
            }
        }
    }
}