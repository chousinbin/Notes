package com.tank.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        this.setSize(2400, 1095);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("坦克大战");
        this.setLocation(320, 180);
        this.addKeyListener(panel);
        // 面板启动多线程进行不断重绘
        new Thread(panel).start();
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
//        this.setIconImage(image);

        // 监听关闭窗口
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭窗口了");
                Recorder.save();
                System.exit(0);
            }
        });
    }
}
