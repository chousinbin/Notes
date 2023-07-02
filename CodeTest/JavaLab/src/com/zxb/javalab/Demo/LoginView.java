package com.zxb.javalab.Demo;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: LoginView
 * @UserName: SinBin
 * @date: 2023-07-02 22:20
 * @Description:
 */
public class LoginView extends JFrame {
    JLabel titleLabel = new JLabel("学生成绩管理系统", JLabel.CENTER);
    JLabel usrLabel = new JLabel("用户名:");
    JLabel pwdLabel = new JLabel("密码:");
    JTextField usrText = new JTextField();
    JPasswordField pwdText = new JPasswordField();
    JButton loginButton = new JButton("登录");
    JButton signButton = new JButton("注册");
    SpringLayout springLayout = new SpringLayout();
    JPanel centerPanel = new JPanel(springLayout);

    LoginView() {
        init();
        setTitle("学生成绩管理系统-登录界面");
        setSize(800, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        Container contentPane = getContentPane();
        titleLabel.setPreferredSize(new Dimension(0,180));
        //设置登录界面组件字体参数
        titleLabel.setFont(new Font("楷体", Font.PLAIN, 60));  //设置字体参数
        Font centerFont = new Font("宋体", Font.PLAIN, 30);
        usrLabel.setFont(centerFont);
        pwdLabel.setFont(centerFont);
        loginButton.setFont(centerFont);
        signButton.setFont(centerFont);
        //设置文本框参数
        usrText.setPreferredSize(new Dimension(200, 50));
        pwdText.setPreferredSize(new Dimension(200, 50));
        usrText.setFont(centerFont);
        pwdText.setFont(centerFont);
        //弹簧布局
        centerPanel.add(usrLabel);
        Spring width1 = Spring.sum(Spring.sum(Spring.width(usrLabel), Spring.width(usrText)), Spring.constant(20));
        int offsetX = width1.getValue() / 2;
        springLayout.putConstraint(SpringLayout.WEST, usrLabel, -offsetX, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH, usrLabel, 40, SpringLayout.NORTH, centerPanel);

        centerPanel.add(usrText);
        springLayout.putConstraint(SpringLayout.WEST, usrText, 20, SpringLayout.EAST, usrLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, usrText, 0, SpringLayout.VERTICAL_CENTER, usrLabel);

        centerPanel.add(pwdLabel);
        springLayout.putConstraint(SpringLayout.EAST, pwdLabel, 0, SpringLayout.EAST, usrLabel);
        springLayout.putConstraint(SpringLayout.NORTH, pwdLabel, 40, SpringLayout.SOUTH, usrLabel);

        centerPanel.add(pwdText);
        springLayout.putConstraint(SpringLayout.WEST, pwdText, 20, SpringLayout.EAST, pwdLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, pwdText, 0, SpringLayout.VERTICAL_CENTER, pwdLabel);

        centerPanel.add(loginButton);
        springLayout.putConstraint(SpringLayout.WEST, loginButton, -offsetX, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, loginButton, 110, SpringLayout.SOUTH, pwdLabel);

        centerPanel.add(signButton);
        springLayout.putConstraint(SpringLayout.EAST, signButton, offsetX, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, signButton, 0, SpringLayout.SOUTH, loginButton);
        //把标题和面板加到主面板
        contentPane.add(titleLabel, BorderLayout.NORTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);
    }
}
