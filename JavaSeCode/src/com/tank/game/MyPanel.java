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
    int enemyTankSize = 3;
    Vector<Bomb> bombs = new Vector<>();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    public MyPanel() {
        hero = new HeroTank(100, 100);
        hero.setSpeed(5);
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirection(2);
            // 敌人创建一个子弹
            enemyTank.shotHeroTank();
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
        g.fillRect(0, 0, 1920, 1080);
        // 绘制自己的坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);
        // 绘制自己子弹
        if (hero.getBullet() != null && hero.getBullet().getIsLive()) {
            g.setColor(Color.cyan);
            g.fillOval(hero.getBullet().getX(), hero.getBullet().getY(), 4, 4);
        }
        // 绘制敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
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

    public void checkHit(Bullet bullet, EnemyTank enemyTank) {
        int xMin = enemyTank.getX();
        int yMin = enemyTank.getY();
        int xMax = xMin;
        int yMax = yMin;

        switch (enemyTank.getDirection()) {
            case 0:
            case 2:
                xMax = enemyTank.getX() + 40;
                yMax = enemyTank.getY() + 60;
                break;
            case 1:
            case 3:
                xMax = enemyTank.getX() + 60;
                yMax = enemyTank.getY() + 40;
                break;
        }

        if (bullet.getX() >= xMin && bullet.getX() <= xMax &&
                bullet.getY() >= yMin && bullet.getY() <= yMax) {
            bullet.setLive(false);
            enemyTank.setLive(false);
            // 击中爆炸
            Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
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
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
        }
        repaint();
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
            if (hero.getBullet() != null && hero.getBullet().getIsLive()) {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    if (enemyTanks.get(i).isLive()) {
                        checkHit(hero.getBullet(), enemyTanks.get(i));
                    }
                }
            }
        }
    }
}
