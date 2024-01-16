package CETMS.View;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    public AdminView() {
        setTitle("CET-MS");
        setSize(1280, 960);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建选项卡对象
        JTabbedPane tabbedPane = new JTabbedPane();
        //设置选项卡标签字体
        tabbedPane.setFont(new Font("黑体", Font.PLAIN, 36));
        //选项卡添加分面板和设置标题
        tabbedPane.addTab("学生管理", new StudentManageView());
        //选项卡添加到主界面
        add(tabbedPane);
    }
}
