package com.SinbinZhou.JavaLab.Demo.View;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: MainView
 * @UserName: SinBin
 * @date: 2023-07-06 17:06
 * @Description:
 */
public class MainView extends JFrame {
    private JTabbedPane tabbedPane = new JTabbedPane();

    public MainView() {
        setTitle("药品进销存管理软件");
        setSize(1280, 960);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置选项卡标签字体
        tabbedPane.setFont(new Font("黑体", Font.PLAIN, 36));
        tabbedPane.addTab("添加药品", new AddPartView());
        tabbedPane.addTab("销售药品", new SalePartController());
        tabbedPane.addTab("修改信息", new UpdatePartView());
        tabbedPane.addTab("药品盘点", new StockPartView());

        add(tabbedPane);
    }
}

