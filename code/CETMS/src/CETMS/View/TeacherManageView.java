package CETMS.View;

import CETMS.Listener.TeacherManageListener;

import javax.swing.*;
import java.awt.*;

public class TeacherManageView extends JPanel {
    private JPanel westPanel;
    private JPanel centerPanel;
    private JScrollPane ScrollPane;
    private MyJTable myJTable;

    private JTextField teacherIdText;
    private JTextField teacherNameText;
    private JTextField teacherSexText;
    private JTextField teacherPhoneText;

    private JLabel teacherIdLabel;
    private JLabel teacherNameLabel;
    private JLabel teacherSexLabel;
    private JLabel teacherPhoneLabel;

    private JTextField teacherQueryText;
    private JButton teacherQueryButton;
    private JButton teacherUpdateButton;
    private JButton teacherAddButton;
    private JButton teacherDeleteButton;

    private SpringLayout springLayout;
    private Font font;
    private Dimension dimension;
    private TeacherManageListener listener;

    public TeacherManageView() {
        setLayout(new BorderLayout());
        // 创建组件对象
        createObject();
        // 初始化字体
        initFont();
        // 初始化组件尺寸
        initDimension();
        // 添加组件
        addComponent();
        // 初始化布局
        initWestPanel();
        initCenterPanel();
        // 添加子面板到主面板
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        // 设置监听
        teacherUpdateButton.addActionListener(listener);
        teacherQueryButton.addActionListener(listener);
        teacherAddButton.addActionListener(listener);
        teacherDeleteButton.addActionListener(listener);
        myJTable.getSelectionModel().addListSelectionListener(listener);
    }

    private void initCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(2000, 1600));
        ScrollPane.setViewportView(myJTable);
    }

    private void initWestPanel() {
        westPanel.setPreferredSize(new Dimension(880, 1600));
        Spring tempWidth = Spring.sum(Spring.sum(Spring.width(teacherIdLabel), Spring.width(teacherIdText)),
                Spring.constant(20));
        int offSetX = tempWidth.getValue() / 2;
        // 输入框
        springLayout.putConstraint(SpringLayout.WEST, teacherIdLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        springLayout.putConstraint(SpringLayout.NORTH, teacherIdLabel, 300,
                SpringLayout.NORTH, westPanel);
        springLayout.putConstraint(SpringLayout.WEST, teacherIdText, 20,
                SpringLayout.EAST, teacherIdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, teacherIdText, 0,
                SpringLayout.NORTH, teacherIdLabel);

        springLayout.putConstraint(SpringLayout.EAST, teacherNameLabel, 0,
                SpringLayout.EAST, teacherIdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, teacherNameLabel, 40,
                SpringLayout.SOUTH, teacherIdLabel);
        springLayout.putConstraint(SpringLayout.WEST, teacherNameText, 20,
                SpringLayout.EAST, teacherNameLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, teacherNameText, 0,
                SpringLayout.VERTICAL_CENTER, teacherNameLabel);

        springLayout.putConstraint(SpringLayout.EAST, teacherSexLabel, 0,
                SpringLayout.EAST, teacherIdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, teacherSexLabel, 40,
                SpringLayout.SOUTH, teacherNameLabel);
        springLayout.putConstraint(SpringLayout.WEST, teacherSexText, 20,
                SpringLayout.EAST, teacherSexLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, teacherSexText, 0,
                SpringLayout.VERTICAL_CENTER, teacherSexLabel);
        //手机
        springLayout.putConstraint(SpringLayout.EAST, teacherPhoneLabel, 0,
                SpringLayout.EAST, teacherIdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, teacherPhoneLabel, 40,
                SpringLayout.SOUTH, teacherSexLabel);
        springLayout.putConstraint(SpringLayout.WEST, teacherPhoneText, 20,
                SpringLayout.EAST, teacherPhoneLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, teacherPhoneText, 0,
                SpringLayout.VERTICAL_CENTER, teacherPhoneLabel);
        // 搜索栏
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, teacherQueryText, 150,
                SpringLayout.VERTICAL_CENTER, teacherPhoneText);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, teacherQueryText, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);

        // 查询按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, teacherQueryButton, 100,
                SpringLayout.VERTICAL_CENTER, teacherQueryText);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, teacherQueryButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);

        // 更新按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, teacherUpdateButton, 100,
                SpringLayout.VERTICAL_CENTER, teacherQueryButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, teacherUpdateButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);

        // 添加按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, teacherAddButton, 100,
                SpringLayout.VERTICAL_CENTER, teacherUpdateButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, teacherAddButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);

        // 删除按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, teacherDeleteButton, 100,
                SpringLayout.VERTICAL_CENTER, teacherAddButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, teacherDeleteButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
    }

    private void createObject() {
        springLayout = new SpringLayout();
        westPanel = new JPanel(springLayout);
        centerPanel = new JPanel(new BorderLayout());
        font = new Font("宋体", Font.PLAIN, 36);
        dimension = new Dimension(300, 50);

        teacherIdLabel = new JLabel("教师工号");
        teacherNameLabel = new JLabel("教师姓名");
        teacherSexLabel = new JLabel("教师性别");
        teacherPhoneLabel = new JLabel("教师手机");

        teacherIdText = new JTextField();
        teacherNameText = new JTextField();
        teacherSexText = new JTextField();
        teacherPhoneText = new JTextField();
        teacherQueryText = new JTextField();

        teacherUpdateButton = new JButton("更新");
        teacherQueryButton = new JButton("查询");
        teacherDeleteButton = new JButton("删除");
        teacherAddButton = new JButton("添加");

        ScrollPane = new JScrollPane();
        myJTable = new MyJTable();
        listener = new TeacherManageListener(this);
    }

    private void initFont() {
        teacherIdLabel.setFont(font);
        teacherNameLabel.setFont(font);
        teacherSexLabel.setFont(font);
        teacherPhoneLabel.setFont(font);

        teacherIdText.setFont(font);
        teacherNameText.setFont(font);
        teacherSexText.setFont(font);
        teacherPhoneText.setFont(font);
        teacherQueryText.setFont(font);

        teacherUpdateButton.setFont(font);
        teacherQueryButton.setFont(font);
        teacherDeleteButton.setFont(font);
        teacherAddButton.setFont(font);
    }

    private void addComponent() {
        westPanel.add(teacherIdLabel);
        westPanel.add(teacherNameLabel);
        westPanel.add(teacherSexLabel);
        westPanel.add(teacherPhoneLabel);
        westPanel.add(teacherIdText);
        westPanel.add(teacherNameText);
        westPanel.add(teacherSexText);
        westPanel.add(teacherPhoneText);
        westPanel.add(teacherQueryText);
        westPanel.add(teacherUpdateButton);
        westPanel.add(teacherQueryButton);
        westPanel.add(teacherDeleteButton);
        westPanel.add(teacherAddButton);
        centerPanel.add(ScrollPane);
    }

    private void initDimension() {
        teacherIdText.setPreferredSize(dimension);
        teacherNameText.setPreferredSize(dimension);
        teacherSexText.setPreferredSize(dimension);
        teacherPhoneText.setPreferredSize(dimension);
        teacherQueryText.setPreferredSize(dimension);
    }
    //getter and setter
    public MyJTable getMyJTable() {
        return myJTable;
    }

    public void setMyJTable(MyJTable myJTable) {
        this.myJTable = myJTable;
    }

    public JTextField getTeacherIdText() {
        return teacherIdText;
    }

    public void setTeacherIdText(JTextField teacherIdText) {
        this.teacherIdText = teacherIdText;
    }

    public JTextField getTeacherNameText() {
        return teacherNameText;
    }

    public void setTeacherNameText(JTextField teacherNameText) {
        this.teacherNameText = teacherNameText;
    }

    public JTextField getTeacherSexText() {
        return teacherSexText;
    }

    public void setTeacherSexText(JTextField teacherSexText) {
        this.teacherSexText = teacherSexText;
    }

    public JTextField getTeacherPhoneText() {
        return teacherPhoneText;
    }

    public void setTeacherPhoneText(JTextField teacherPhoneText) {
        this.teacherPhoneText = teacherPhoneText;
    }

    public JTextField getTeacherQueryText() {
        return teacherQueryText;
    }

    public void setTeacherQueryText(JTextField teacherQueryText) {
        this.teacherQueryText = teacherQueryText;
    }

    public JButton getTeacherQueryButton() {
        return teacherQueryButton;
    }

    public void setTeacherQueryButton(JButton teacherQueryButton) {
        this.teacherQueryButton = teacherQueryButton;
    }

    public JButton getTeacherUpdateButton() {
        return teacherUpdateButton;
    }

    public void setTeacherUpdateButton(JButton teacherUpdateButton) {
        this.teacherUpdateButton = teacherUpdateButton;
    }

    public JButton getTeacherAddButton() {
        return teacherAddButton;
    }

    public void setTeacherAddButton(JButton teacherAddButton) {
        this.teacherAddButton = teacherAddButton;
    }

    public JButton getTeacherDeleteButton() {
        return teacherDeleteButton;
    }

    public void setTeacherDeleteButton(JButton teacherDeleteButton) {
        this.teacherDeleteButton = teacherDeleteButton;
    }
}

