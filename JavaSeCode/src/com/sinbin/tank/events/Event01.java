package com.sinbin.tank.events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/23 13:58
 * @Description: 通过键盘控制小球移动
 */
public class Event01 extends JFrame{
    MyPanel panel = null;
    public static void main(String[] args) {
        new Event01();
    }

    public Event01() {
        panel = new MyPanel();
        this.add(panel);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(320, 180);
        this.setTitle("小球移动");
        this.addKeyListener(panel);
    }
}
// KeyListener 监听键盘事件
class MyPanel extends JPanel implements KeyListener {
    private int x = 10;
    private int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 10, 10);
    }
    // 监听键盘字符输入
    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("键盘输入");
    }
    // 监听键盘按键按压
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + "键盘按压");
        // 向下
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y ++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y --;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x --;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x ++;
        }
        // 重绘
        this.repaint();
    }
    // 监听键盘按键松开
    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("键盘松开");
    }
}
