package com.SinbinZhou.JavaLab.test;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: SpringLayout
 * @UserName: SinBin
 * @date: 2023-07-02 21:36
 * @Description:
 */
public class SpringLayout1 {
    public static void main(String[] args) {
        new Frame1();
    }
}

class Frame1 extends JFrame {
    SpringLayout layout = new SpringLayout();
    JPanel panel = new JPanel(layout);
    JLabel label1 = new JLabel("用户名");
    JTextField text1 = new JTextField(10);
    JLabel label2 = new JLabel("密码");
    JTextField text2 = new JTextField(10);
    Frame1() {
        init();
        setTitle("SpringLayout");
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        Container contentPane = getContentPane();

        panel.add(label1);
        panel.add(text1);
        panel.add(label2);
        panel.add(text2);

        SpringLayout.Constraints cLabel1 = layout.getConstraints(label1);
        cLabel1.setX(Spring.constant(80));
        cLabel1.setY(Spring.constant(80));

        //设置text1 西边 距离 label1 20
        Spring label1East = cLabel1.getConstraint(SpringLayout.EAST);
        SpringLayout.Constraints cText1 = layout.getConstraints(text1);
        cText1.setConstraint(SpringLayout.WEST, Spring.sum(label1East, Spring.constant(20)));
        cText1.setConstraint(SpringLayout.NORTH, cLabel1.getConstraint(SpringLayout.NORTH));

        Spring label1South = cLabel1.getConstraint(SpringLayout.SOUTH);  //label1南边参数
        SpringLayout.Constraints cLabel2 = layout.getConstraints(label2);  //获取label2的约束
        cLabel2.setConstraint(SpringLayout.NORTH, Spring.sum(label1South, Spring.constant(20)));
        cLabel2.setConstraint(SpringLayout.EAST, cLabel1.getConstraint(SpringLayout.EAST));

        SpringLayout.Constraints cText2 = layout.getConstraints(text2);
        cText2.setConstraint(SpringLayout.WEST, Spring.sum(label1East, Spring.constant(20)));
        cText2.setConstraint(SpringLayout.NORTH, cLabel2.getConstraint(SpringLayout.NORTH));

        contentPane.add(panel);
    }
}
