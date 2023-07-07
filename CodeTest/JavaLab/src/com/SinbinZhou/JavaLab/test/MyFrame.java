package com.SinbinZhou.JavaLab.test;

import javax.swing.*;


/**
 * @ClassName: com.zxb.javalab.test.MyFrame
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
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("123", new JPanel());
        add(jTabbedPane);

    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
