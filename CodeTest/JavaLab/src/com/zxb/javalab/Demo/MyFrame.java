package com.zxb.javalab.Demo;

import java.awt.*;
import javax.swing.*;


/**
 * @ClassName: com.zxb.javalab.Demo.MyFrame
 * @UserName: SinBin
 * @date: 2023-06-29 18:58
 * @Description:
 */
public class MyFrame extends JFrame {
    JButton b1 = new JButton("按钮1");
    JButton b2 = new JButton("按钮2");
    JButton b3 = new JButton("按钮3");
    MyFrame() {
        init();
        setTitle("学生管理系统");
        setSize(1280, 960);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(new FlowLayout());

    }
}
