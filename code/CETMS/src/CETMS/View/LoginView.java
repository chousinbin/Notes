package CETMS.View;

import CETMS.Listener.LoginListener;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private JLabel titleLabel;
    private JLabel usrLabel;
    private JLabel pwdLabel;
    private JTextField usrText;
    private JPasswordField pwdText;
    private JButton loginButton;
    private JButton resetButton;
    private SpringLayout springLayout;
    private JPanel centerPanel;

    private JRadioButton adminRadioButton;
    private JRadioButton teacherRadioButton;
    private JRadioButton studentRadioButton;
    private ButtonGroup roleButtonGroup;



    public LoginView() {
        createObject();
        initSizeFront();  //字体的初始化, 文本框的大小的初始化
        initLayout();  //初始化JPanel面板的弹簧布局, 以及组件添加
        addListener();  //为组件增加监听器

        setTitle("CET-MS");
        setSize(800, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createObject() {
        titleLabel = new JLabel("英语四六级成绩管理系统", JLabel.CENTER);
        usrLabel = new JLabel("账号:");
        pwdLabel = new JLabel("密码:");
        usrText = new JTextField();
        pwdText = new JPasswordField();
        loginButton = new JButton("登录");
        resetButton = new JButton("重置");
        springLayout = new SpringLayout();
        centerPanel = new JPanel(springLayout);

        adminRadioButton = new JRadioButton("管理");
        teacherRadioButton = new JRadioButton("教师");
        studentRadioButton = new JRadioButton("学生");
        roleButtonGroup = new ButtonGroup();
    }
    void initSizeFront() {
        //初始化标题大小和字体
        titleLabel.setPreferredSize(new Dimension(0,180));
        titleLabel.setFont(new Font("楷体", Font.PLAIN, 60));
        //初始化标签文本框按钮字体
        Font centerFont = new Font("宋体", Font.PLAIN, 30);
        usrLabel.setFont(centerFont);
        pwdLabel.setFont(centerFont);
        loginButton.setFont(centerFont);
        resetButton.setFont(centerFont);
        usrText.setFont(centerFont);
        pwdText.setFont(centerFont);
        adminRadioButton.setFont(centerFont);
        teacherRadioButton.setFont(centerFont);
        studentRadioButton.setFont(centerFont);
        //初始化文本框大小
        usrText.setPreferredSize(new Dimension(200, 50));
        pwdText.setPreferredSize(new Dimension(200, 50));
        //初始化密码框默认字符
        pwdText.setEchoChar('*');
        //初始化按钮大小
        adminRadioButton.setPreferredSize(new Dimension(150, 50));
        teacherRadioButton.setPreferredSize(new Dimension(150, 50));
        studentRadioButton.setPreferredSize(new Dimension(150, 50));
    }
    void initLayout() {
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

        roleButtonGroup.add(adminRadioButton);
        roleButtonGroup.add(teacherRadioButton);
        roleButtonGroup.add(studentRadioButton);

        Spring buttonWidth = Spring.sum(Spring.width(adminRadioButton),
                Spring.sum(Spring.width(teacherRadioButton),
                        Spring.sum(Spring.width(studentRadioButton),
                                Spring.constant(20))));
        int offSetButton = buttonWidth.getValue() / 2;
        centerPanel.add(adminRadioButton);
        springLayout.putConstraint(SpringLayout.WEST, adminRadioButton, -offSetButton, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH, adminRadioButton, 40, SpringLayout.SOUTH, pwdLabel);

        centerPanel.add(teacherRadioButton);
        springLayout.putConstraint(SpringLayout.WEST, teacherRadioButton, 10, SpringLayout.EAST, adminRadioButton);
        springLayout.putConstraint(SpringLayout.NORTH, teacherRadioButton, 0, SpringLayout.NORTH, adminRadioButton);

        centerPanel.add(studentRadioButton);
        springLayout.putConstraint(SpringLayout.WEST, studentRadioButton, 10, SpringLayout.EAST, teacherRadioButton);
        springLayout.putConstraint(SpringLayout.NORTH, studentRadioButton, 0, SpringLayout.NORTH, teacherRadioButton);

        centerPanel.add(loginButton);
        springLayout.putConstraint(SpringLayout.WEST, loginButton, -offsetX, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.NORTH, loginButton, 40, SpringLayout.SOUTH, adminRadioButton);

        centerPanel.add(resetButton);
        springLayout.putConstraint(SpringLayout.EAST, resetButton, offsetX, SpringLayout.HORIZONTAL_CENTER, centerPanel);
        springLayout.putConstraint(SpringLayout.SOUTH, resetButton, 0, SpringLayout.SOUTH, loginButton);

        //把标题和面板加到主面板
        add(titleLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    void addListener() {
        LoginListener listener = new LoginListener(this);
        loginButton.addActionListener(listener);
        resetButton.addActionListener(listener);
        pwdText.addActionListener(listener);
        adminRadioButton.addActionListener(listener);
        teacherRadioButton.addActionListener(listener);
        studentRadioButton.addActionListener(listener);
    }

    public JTextField getUsrText() {
        return usrText;
    }

    public JPasswordField getPwdText() {
        return pwdText;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }
    public JRadioButton getAdminRadioButton() {
        return adminRadioButton;
    }

    public void setAdminRadioButton(JRadioButton adminRadioButton) {
        this.adminRadioButton = adminRadioButton;
    }

    public JRadioButton getTeacherRadioButton() {
        return teacherRadioButton;
    }

    public void setTeacherRadioButton(JRadioButton teacherRadioButton) {
        this.teacherRadioButton = teacherRadioButton;
    }

    public JRadioButton getStudentRadioButton() {
        return studentRadioButton;
    }

    public void setStudentRadioButton(JRadioButton studentRadioButton) {
        this.studentRadioButton = studentRadioButton;
    }

    public ButtonGroup getRoleButtonGroup() {
        return roleButtonGroup;
    }

    public void setRoleButtonGroup(ButtonGroup roleButtonGroup) {
        this.roleButtonGroup = roleButtonGroup;
    }
}
