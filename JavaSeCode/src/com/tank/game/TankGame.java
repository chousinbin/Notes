package com.tank.game;

import javax.swing.*;
import java.awt.*;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 13:09
 * @Description:
 */
public class TankGame extends JFrame {
    MyPanel panel = null;
    public static void main(String[] args) {
        new TankGame();
    }

    public TankGame() {
        panel = new MyPanel();
        this.add(panel);
        // 边框数据：横向 16 纵向 39
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("坦克大战");
        this.setLocation(320, 180);
        this.addKeyListener(panel);
        // 面板启动多线程进行不断重绘
        new Thread(panel).start();
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
        this.setIconImage(image);
    }
}
