package com.tank.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2024/11/22 20:34
 * @Description:
 */
public class DrawCircle extends JFrame{
    private MyPanel mp;

    public static void main(String[] args) {
        new DrawCircle();
    }

    private DrawCircle() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1920, 1080);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("title");
        this.setLocation(320, 180);
    }

}

class MyPanel extends JPanel {
    /*
        当组件第一次在屏幕显示的时候，会自动调用 paint 方法
        paint() 被调用的时机
        1. 窗口最小化或最大化
        2. 窗口的大小发生变化
        3. repaint 方法被调用
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(100, 100, 50, 50);
        // 填充椭圆
        g.setColor(Color.blue);
        g.fillOval(200, 200, 10,10);

        // 画图片
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.png"));
        g.drawImage(image, 500, 500, 200, 200, this);

        // 画字符串
        g.setColor(Color.GREEN);
        g.setFont(new Font("楷书", Font.BOLD, 50));
        g.drawString("你好", 600, 100);
    }
}
