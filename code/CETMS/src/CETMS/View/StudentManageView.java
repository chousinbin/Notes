package CETMS.View;

import CETMS.Listener.StudentManageListener;

import javax.swing.*;
import java.awt.*;

public class StudentManageView extends JPanel {
    private JPanel westPanel;
    private JPanel centerPanel;
    private JScrollPane ScrollPane;
    private MyJTable myJTable;

    private JTextField studentIdText;
    private JTextField studentNameText;
    private JTextField studentSexText;
    private JTextField studentSchoolText;
    private JTextField studentAcademyText;
    private JTextField studentMajorText;
    private JTextField studentClassText;

    private JLabel studentIdLabel;
    private JLabel studentNameLabel;
    private JLabel studentSexLabel;
    private JLabel studentSchoolLabel;
    private JLabel studentAcademyLabel;
    private JLabel studentMajorLabel;
    private JLabel studentClassLabel;

    private JTextField studentQueryText;
    private JButton studentQueryButton;
    private JButton studentUpdateButton;
    private JButton studentAddButton;
    private JButton studentDeleteButton;

    private SpringLayout springLayout;
    private Font font;
    private Dimension dimension;
    private StudentManageListener listener;

    public StudentManageView() {
        setLayout(new BorderLayout());
        //创建组件对象
        createObject();
        //初始化字体
        initFont();
        //初始化尺寸
        initDimension();
        //组件添加
        addComponent();
        //初始化布局
        initWestPanel();
        initCenterPanel();
        //分面板到主面板
        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        //设置监听
        studentUpdateButton.addActionListener(listener);
        studentQueryButton.addActionListener(listener);
        studentAddButton.addActionListener(listener);
        studentDeleteButton.addActionListener(listener);
        myJTable.getSelectionModel().addListSelectionListener(listener);
    }

    private void initCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(2000, 1600));
        ScrollPane.setViewportView(myJTable);
    }

    private void initWestPanel() {
        westPanel.setPreferredSize(new Dimension(880,1600));

        Spring tempWidth = Spring.sum(Spring.sum(Spring.width(studentIdLabel), Spring.width(studentIdText)),
                Spring.constant(20));
        int offSetX = tempWidth.getValue() / 2;
        //输入栏布局
        springLayout.putConstraint(SpringLayout.WEST, studentIdLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        springLayout.putConstraint(SpringLayout.NORTH, studentIdLabel, 300,
                SpringLayout.NORTH, westPanel);

        springLayout.putConstraint(SpringLayout.WEST, studentIdText, 20,
                SpringLayout.EAST, studentIdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, studentIdText, 0,
                SpringLayout.NORTH, studentIdLabel);

        springLayout.putConstraint(SpringLayout.EAST, studentNameLabel, 0,
                SpringLayout.EAST, studentIdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, studentNameLabel, 40,
                SpringLayout.SOUTH, studentIdLabel);

        springLayout.putConstraint(SpringLayout.WEST, studentNameText, 20,
                SpringLayout.EAST, studentNameLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentNameText, 0,
                SpringLayout.VERTICAL_CENTER, studentNameLabel);

        springLayout.putConstraint(SpringLayout.EAST, studentSexLabel, 0,
                SpringLayout.EAST, studentNameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, studentSexLabel, 40,
                SpringLayout.SOUTH, studentNameLabel);

        springLayout.putConstraint(SpringLayout.WEST, studentSexText, 20,
                SpringLayout.EAST, studentSexLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentSexText, 0,
                SpringLayout.VERTICAL_CENTER, studentSexLabel);

        springLayout.putConstraint(SpringLayout.EAST, studentSchoolLabel, 0,
                SpringLayout.EAST, studentIdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, studentSchoolLabel, 40,
                SpringLayout.SOUTH, studentSexLabel);

        springLayout.putConstraint(SpringLayout.WEST, studentSchoolText, 20,
                SpringLayout.EAST, studentSchoolLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentSchoolText, 0,
                SpringLayout.VERTICAL_CENTER, studentSchoolLabel);

        springLayout.putConstraint(SpringLayout.EAST, studentAcademyLabel, 0,
                SpringLayout.EAST, studentIdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, studentAcademyLabel, 40,
                SpringLayout.SOUTH, studentSchoolLabel);

        springLayout.putConstraint(SpringLayout.WEST, studentAcademyText, 20,
                SpringLayout.EAST, studentAcademyLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentAcademyText, 0,
                SpringLayout.VERTICAL_CENTER, studentAcademyLabel);

        springLayout.putConstraint(SpringLayout.EAST, studentMajorLabel, 0,
                SpringLayout.EAST, studentIdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, studentMajorLabel, 40,
                SpringLayout.SOUTH, studentAcademyText);

        springLayout.putConstraint(SpringLayout.WEST, studentMajorText, 20,
                SpringLayout.EAST, studentMajorLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentMajorText, 0,
                SpringLayout.VERTICAL_CENTER, studentMajorLabel);

        springLayout.putConstraint(SpringLayout.EAST, studentClassLabel, 0,
                SpringLayout.EAST, studentIdLabel);
        springLayout.putConstraint(SpringLayout.NORTH, studentClassLabel, 40,
                SpringLayout.SOUTH, studentMajorText);

        springLayout.putConstraint(SpringLayout.WEST, studentClassText, 20,
                SpringLayout.EAST, studentClassLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentClassText, 0,
                SpringLayout.VERTICAL_CENTER, studentClassLabel);
        //搜索栏
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentQueryText, 150,
                SpringLayout.VERTICAL_CENTER, studentClassText);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, studentQueryText, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        //查询按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentQueryButton, 100,
                SpringLayout.VERTICAL_CENTER, studentQueryText);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, studentQueryButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        //更新按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentUpdateButton, 100,
                SpringLayout.VERTICAL_CENTER, studentQueryButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, studentUpdateButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        //插入按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentAddButton, 100,
                SpringLayout.VERTICAL_CENTER, studentUpdateButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, studentAddButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        //删除按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentDeleteButton, 100,
                SpringLayout.VERTICAL_CENTER, studentAddButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, studentDeleteButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
    }

    private void createObject() {
        springLayout = new SpringLayout();
        westPanel = new JPanel(springLayout);
        centerPanel = new JPanel(new BorderLayout());
        font = new Font("宋体", Font.PLAIN, 36);
        dimension = new Dimension(300, 50);

        studentIdLabel = new JLabel("学生学号");
        studentNameLabel = new JLabel("学生姓名");
        studentSexLabel = new JLabel("学生性别");
        studentSchoolLabel = new JLabel("学生学校");
        studentAcademyLabel = new JLabel("学生学院");
        studentMajorLabel = new JLabel("学生专业");
        studentClassLabel = new JLabel("学生班级");

        studentIdText = new JTextField();
        studentNameText = new JTextField();
        studentSexText = new JTextField();
        studentSchoolText = new JTextField();
        studentAcademyText = new JTextField();
        studentMajorText = new JTextField();
        studentClassText = new JTextField();
        studentQueryText = new JTextField();

        studentUpdateButton = new JButton("更新");
        studentQueryButton = new JButton("查询");
        studentDeleteButton = new JButton("删除");
        studentAddButton = new JButton("添加");

        ScrollPane = new JScrollPane();
        myJTable = new MyJTable();
        listener = new StudentManageListener(this);
    }

    private void initFont() {
        studentIdLabel.setFont(font);
        studentNameLabel.setFont(font);
        studentSexLabel.setFont(font);
        studentSchoolLabel.setFont(font);
        studentAcademyLabel.setFont(font);
        studentMajorLabel.setFont(font);
        studentClassLabel.setFont(font);

        studentIdText.setFont(font);
        studentNameText.setFont(font);
        studentSexText.setFont(font);
        studentSchoolText.setFont(font);
        studentAcademyText.setFont(font);
        studentMajorText.setFont(font);
        studentClassText.setFont(font);
        studentQueryText.setFont(font);

        studentUpdateButton.setFont(font);
        studentQueryButton.setFont(font);
        studentDeleteButton.setFont(font);
        studentAddButton.setFont(font);
    }

    private void addComponent() {
        westPanel.add(studentIdLabel);
        westPanel.add(studentNameLabel);
        westPanel.add(studentSexLabel);
        westPanel.add(studentSchoolLabel);
        westPanel.add(studentAcademyLabel);
        westPanel.add(studentMajorLabel);
        westPanel.add(studentClassLabel);
        westPanel.add(studentIdText);
        westPanel.add(studentNameText);
        westPanel.add(studentSexText);
        westPanel.add(studentSchoolText);
        westPanel.add(studentAcademyText);
        westPanel.add(studentMajorText);
        westPanel.add(studentClassText);
        westPanel.add(studentQueryText);
        westPanel.add(studentUpdateButton);
        westPanel.add(studentQueryButton);
        westPanel.add(studentDeleteButton);
        westPanel.add(studentAddButton);
        centerPanel.add(ScrollPane);
    }

    private void initDimension() {
        studentIdText.setPreferredSize(dimension);
        studentNameText.setPreferredSize(dimension);
        studentSexText.setPreferredSize(dimension);
        studentSchoolText.setPreferredSize(dimension);
        studentAcademyText.setPreferredSize(dimension);
        studentMajorText.setPreferredSize(dimension);
        studentClassText.setPreferredSize(dimension);
        studentQueryText.setPreferredSize(dimension);
    }

    public JScrollPane getScrollPane() {
        return ScrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        ScrollPane = scrollPane;
    }

    public MyJTable getMyJTable() {
        return myJTable;
    }

    public void setMyJTable(MyJTable myJTable) {
        this.myJTable = myJTable;
    }

    public JTextField getStudentIdText() {
        return studentIdText;
    }

    public void setStudentIdText(JTextField studentIdText) {
        this.studentIdText = studentIdText;
    }

    public JTextField getStudentNameText() {
        return studentNameText;
    }

    public void setStudentNameText(JTextField studentNameText) {
        this.studentNameText = studentNameText;
    }

    public JTextField getStudentSexText() {
        return studentSexText;
    }

    public void setStudentSexText(JTextField studentSexText) {
        this.studentSexText = studentSexText;
    }

    public JTextField getStudentSchoolText() {
        return studentSchoolText;
    }

    public void setStudentSchoolText(JTextField studentSchoolText) {
        this.studentSchoolText = studentSchoolText;
    }

    public JTextField getStudentAcademyText() {
        return studentAcademyText;
    }

    public void setStudentAcademyText(JTextField studentAcademyText) {
        this.studentAcademyText = studentAcademyText;
    }

    public JTextField getStudentClassText() {
        return studentClassText;
    }

    public void setStudentClassText(JTextField studentClassText) {
        this.studentClassText = studentClassText;
    }

    public JTextField getStudentQueryText() {
        return studentQueryText;
    }

    public void setStudentQueryText(JTextField studentQueryText) {
        this.studentQueryText = studentQueryText;
    }

    public JButton getStudentQueryButton() {
        return studentQueryButton;
    }

    public void setStudentQueryButton(JButton studentQueryButton) {
        this.studentQueryButton = studentQueryButton;
    }

    public JButton getStudentUpdateButton() {
        return studentUpdateButton;
    }

    public void setStudentUpdateButton(JButton studentUpdateButton) {
        this.studentUpdateButton = studentUpdateButton;
    }

    public JButton getStudentAddButton() {
        return studentAddButton;
    }

    public void setStudentAddButton(JButton studentAddButton) {
        this.studentAddButton = studentAddButton;
    }

    public JButton getStudentDeleteButton() {
        return studentDeleteButton;
    }

    public void setStudentDeleteButton(JButton studentDeleteButton) {
        this.studentDeleteButton = studentDeleteButton;
    }

    public JTextField getStudentMajorText() {
        return studentMajorText;
    }

    public void setStudentMajorText(JTextField studentMajorText) {
        this.studentMajorText = studentMajorText;
    }
}

