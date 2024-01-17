package CETMS.View;

import CETMS.Listener.TempListener;

import javax.swing.*;
import java.awt.*;

public class StudentView extends JFrame {
    JTabbedPane tabbedPane;
    public StudentView() {
        setTitle("CET-MS-学生界面");
        setSize(1280, 960);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建选项卡对象
        tabbedPane = new JTabbedPane();
        //设置选项卡标签字体
        tabbedPane.setFont(new Font("黑体", Font.PLAIN, 36));
        //选项卡添加分面板和设置标题
        tabbedPane.addTab("成绩查询", new GradeQueryView());
        tabbedPane.addTab("密码修改", new PwdUpdateView());
        tabbedPane.addTab("切换账号", new PwdUpdateView());
        //选项卡添加到主界面
        add(tabbedPane);
        // 设置监听器
        TempListener listener = new TempListener(this);
        tabbedPane.addChangeListener(listener);
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }
}
