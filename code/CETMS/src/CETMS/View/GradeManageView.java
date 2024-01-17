package CETMS.View;

import CETMS.Listener.GradeManageListener;

import javax.swing.*;
import java.awt.*;

public class GradeManageView extends JPanel {
    private JPanel westPanel;
    private JPanel centerPanel;
    private JScrollPane ScrollPane;
    private MyJTable myJTable;

    private JComboBox<String> testYearComboBox;
    private JComboBox<String> testMonthComboBox;
    private JComboBox<String> testTypeComboBox;
    private JTextField studentIdText;
    private JTextField listeningGradeText;
    private JTextField readingGradeText;
    private JTextField writingGradeText;

    private JLabel testDateLabel;
    private JLabel testYearLabel;
    private JLabel testMonthLabel;
    private JLabel testTypeLabel;
    private JLabel studentIdLabel;
    private JLabel listeningGradeLabel;
    private JLabel readingGradeLabel;
    private JLabel writingGradeLabel;

    private JTextField gradeQueryText;
    private JButton gradeQueryButton;
    private JButton gradeUpdateButton;
    private JButton gradeAddButton;
    private JButton gradeDeleteButton;

    private SpringLayout springLayout;
    private Font font;
    private Dimension dimension;
    private GradeManageListener listener;

    public GradeManageView() {
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
        gradeUpdateButton.addActionListener(listener);
        gradeAddButton.addActionListener(listener);
        gradeDeleteButton.addActionListener(listener);
        gradeQueryButton.addActionListener(listener);
        myJTable.getSelectionModel().addListSelectionListener(listener);
    }

    private void initCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(2600, 1600));
        ScrollPane.setViewportView(myJTable);
    }

    private void initWestPanel() {
        westPanel.setPreferredSize(new Dimension(600, 1600));

        Spring tempWidth = Spring.sum(Spring.width(testDateLabel),
                Spring.constant(320));
        int offSetX = tempWidth.getValue() / 2;
        //输入栏布局
        springLayout.putConstraint(SpringLayout.WEST, testDateLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, testDateLabel, 300,
                SpringLayout.NORTH, westPanel);

        springLayout.putConstraint(SpringLayout.WEST, testYearComboBox, 20,
                SpringLayout.EAST, testDateLabel);
        springLayout.putConstraint(SpringLayout.NORTH, testYearComboBox, 0,
                SpringLayout.NORTH, testDateLabel);

        springLayout.putConstraint(SpringLayout.WEST, testYearLabel, 10,
                SpringLayout.EAST, testYearComboBox);
        springLayout.putConstraint(SpringLayout.NORTH, testYearLabel, 0,
                SpringLayout.NORTH, testYearComboBox);

        springLayout.putConstraint(SpringLayout.WEST, testMonthComboBox, 10,
                SpringLayout.EAST, testYearLabel);
        springLayout.putConstraint(SpringLayout.NORTH, testMonthComboBox, 0,
                SpringLayout.NORTH, testYearLabel);

        springLayout.putConstraint(SpringLayout.WEST, testMonthLabel, 10,
                SpringLayout.EAST, testMonthComboBox);
        springLayout.putConstraint(SpringLayout.NORTH, testMonthLabel, 0,
                SpringLayout.NORTH, testMonthComboBox);

        springLayout.putConstraint(SpringLayout.EAST, testTypeLabel, 0,
                SpringLayout.EAST, testDateLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, testTypeLabel, 100,
                SpringLayout.VERTICAL_CENTER, testDateLabel);
        springLayout.putConstraint(SpringLayout.WEST, testTypeComboBox, 20,
                SpringLayout.EAST, testTypeLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, testTypeComboBox, 0,
                SpringLayout.VERTICAL_CENTER, testTypeLabel);

        springLayout.putConstraint(SpringLayout.EAST, studentIdLabel, 0,
                SpringLayout.EAST, testDateLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentIdLabel, 100,
                SpringLayout.VERTICAL_CENTER, testTypeLabel);
        springLayout.putConstraint(SpringLayout.WEST, studentIdText, 20,
                SpringLayout.EAST, studentIdLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, studentIdText, 0,
                SpringLayout.VERTICAL_CENTER, studentIdLabel);

        springLayout.putConstraint(SpringLayout.EAST, listeningGradeLabel, 0,
                SpringLayout.EAST, testDateLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, listeningGradeLabel, 100,
                SpringLayout.VERTICAL_CENTER, studentIdLabel);
        springLayout.putConstraint(SpringLayout.WEST, listeningGradeText, 20,
                SpringLayout.EAST, listeningGradeLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, listeningGradeText, 0,
                SpringLayout.VERTICAL_CENTER, listeningGradeLabel);

        springLayout.putConstraint(SpringLayout.EAST, readingGradeLabel, 0,
                SpringLayout.EAST, testDateLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, readingGradeLabel, 100,
                SpringLayout.VERTICAL_CENTER, listeningGradeLabel);
        springLayout.putConstraint(SpringLayout.WEST, readingGradeText, 20,
                SpringLayout.EAST, readingGradeLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, readingGradeText, 0,
                SpringLayout.VERTICAL_CENTER, readingGradeLabel);

        springLayout.putConstraint(SpringLayout.EAST, writingGradeLabel, 0,
                SpringLayout.EAST, testDateLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, writingGradeLabel, 100,
                SpringLayout.VERTICAL_CENTER, readingGradeLabel);
        springLayout.putConstraint(SpringLayout.WEST, writingGradeText, 20,
                SpringLayout.EAST, writingGradeLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, writingGradeText, 0,
                SpringLayout.VERTICAL_CENTER, writingGradeLabel);

        // 查询框
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, gradeQueryText,
                200, SpringLayout.VERTICAL_CENTER, writingGradeLabel);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gradeQueryText,
                0, SpringLayout.HORIZONTAL_CENTER, westPanel);
        // 查询按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, gradeQueryButton,
                100, SpringLayout.VERTICAL_CENTER, gradeQueryText);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gradeQueryButton,
                0, SpringLayout.HORIZONTAL_CENTER, westPanel);
        // 添加按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, gradeAddButton,
                100, SpringLayout.VERTICAL_CENTER, gradeQueryButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gradeAddButton,
                0, SpringLayout.HORIZONTAL_CENTER, westPanel);
        // 更新按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, gradeUpdateButton,
                100, SpringLayout.VERTICAL_CENTER, gradeAddButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gradeUpdateButton,
                0, SpringLayout.HORIZONTAL_CENTER, westPanel);
        // 删除按钮
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, gradeDeleteButton,
                100, SpringLayout.VERTICAL_CENTER, gradeUpdateButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gradeDeleteButton,
                0, SpringLayout.HORIZONTAL_CENTER, westPanel);
    }

    private void createObject() {
        springLayout = new SpringLayout();
        westPanel = new JPanel(springLayout);
        centerPanel = new JPanel(new BorderLayout());
        font = new Font("宋体", Font.PLAIN, 36);
        dimension = new Dimension(300, 50);

        testDateLabel = new JLabel("考试日期");
        testYearLabel = new JLabel("年");
        testMonthLabel = new JLabel("月");
        testTypeLabel = new JLabel("考试类型");
        studentIdLabel = new JLabel("学生学号");
        listeningGradeLabel = new JLabel("听力成绩");
        readingGradeLabel = new JLabel("阅读成绩");
        writingGradeLabel = new JLabel("写作成绩");

        String[] optionsYear = {"2020", "2021", "2022", "2023", "2024", "2025",
                "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033",
                "2034", "2035"};
        String[] optionsMonth = {"6", "12"};
        testYearComboBox = new JComboBox<>(optionsYear);
        testMonthComboBox = new JComboBox<>(optionsMonth);
        String[] options = {"CET4", "CET6"};
        testTypeComboBox = new JComboBox<>(options);
        studentIdText = new JTextField();
        listeningGradeText = new JTextField();
        readingGradeText = new JTextField();
        writingGradeText = new JTextField();


        gradeQueryText = new JTextField();
        gradeUpdateButton = new JButton("更新");
        gradeQueryButton = new JButton("查询");
        gradeDeleteButton = new JButton("删除");
        gradeAddButton = new JButton("添加");

        ScrollPane = new JScrollPane();
        myJTable = new MyJTable();
        listener = new GradeManageListener(this);
    }

    private void addComponent() {
        westPanel.add(testDateLabel);
        westPanel.add(testYearLabel);
        westPanel.add(testMonthLabel);
        westPanel.add(testTypeLabel);
        westPanel.add(studentIdLabel);
        westPanel.add(listeningGradeLabel);
        westPanel.add(readingGradeLabel);
        westPanel.add(writingGradeLabel);

        westPanel.add(testYearComboBox);
        westPanel.add(testMonthComboBox);
        westPanel.add(testTypeComboBox);
        westPanel.add(studentIdText);
        westPanel.add(listeningGradeText);
        westPanel.add(readingGradeText);
        westPanel.add(writingGradeText);

        westPanel.add(gradeQueryText);
        westPanel.add(gradeUpdateButton);
        westPanel.add(gradeQueryButton);
        westPanel.add(gradeDeleteButton);
        westPanel.add(gradeAddButton);

        centerPanel.add(ScrollPane);
    }

    private void initDimension() {
        Spring labelWidth = Spring.sum(Spring.width(testYearLabel),
                Spring.sum(Spring.width(testMonthLabel),
                        Spring.constant(30)));
        int testYearLabelWidth = (300 - labelWidth.getValue()) / 2;
        testYearComboBox.setPreferredSize(new Dimension(testYearLabelWidth, 50));
        testMonthComboBox.setPreferredSize(new Dimension(testYearLabelWidth, 50));
        testTypeComboBox.setPreferredSize(dimension);
        studentIdText.setPreferredSize(dimension);
        listeningGradeText.setPreferredSize(dimension);
        readingGradeText.setPreferredSize(dimension);
        writingGradeText.setPreferredSize(dimension);
        gradeQueryText.setPreferredSize(dimension);
    }

    private void initFont() {
        testDateLabel.setFont(font);
        testYearLabel.setFont(font);
        testMonthLabel.setFont(font);
        testTypeLabel.setFont(font);
        studentIdLabel.setFont(font);
        listeningGradeLabel.setFont(font);
        readingGradeLabel.setFont(font);
        writingGradeLabel.setFont(font);

        testYearComboBox.setFont(font);
        testMonthComboBox.setFont(font);
        testTypeComboBox.setFont(font);
        studentIdText.setFont(font);
        listeningGradeText.setFont(font);
        readingGradeText.setFont(font);
        writingGradeText.setFont(font);
        gradeQueryText.setFont(font);

        gradeUpdateButton.setFont(font);
        gradeQueryButton.setFont(font);
        gradeDeleteButton.setFont(font);
        gradeAddButton.setFont(font);
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

    public JComboBox<String> getTestYearComboBox() {
        return testYearComboBox;
    }

    public void setTestYearComboBox(JComboBox<String> testYearComboBox) {
        this.testYearComboBox = testYearComboBox;
    }

    public JComboBox<String> getTestMonthComboBox() {
        return testMonthComboBox;
    }

    public void setTestMonthComboBox(JComboBox<String> testMonthComboBox) {
        this.testMonthComboBox = testMonthComboBox;
    }

    public JComboBox<String> getTestTypeComboBox() {
        return testTypeComboBox;
    }

    public void setTestTypeComboBox(JComboBox<String> testTypeComboBox) {
        this.testTypeComboBox = testTypeComboBox;
    }

    public JTextField getStudentIdText() {
        return studentIdText;
    }

    public void setStudentIdText(JTextField studentIdText) {
        this.studentIdText = studentIdText;
    }

    public JTextField getListeningGradeText() {
        return listeningGradeText;
    }

    public void setListeningGradeText(JTextField listeningGradeText) {
        this.listeningGradeText = listeningGradeText;
    }

    public JTextField getReadingGradeText() {
        return readingGradeText;
    }

    public void setReadingGradeText(JTextField readingGradeText) {
        this.readingGradeText = readingGradeText;
    }

    public JTextField getWritingGradeText() {
        return writingGradeText;
    }

    public void setWritingGradeText(JTextField writingGradeText) {
        this.writingGradeText = writingGradeText;
    }

    public JTextField getGradeQueryText() {
        return gradeQueryText;
    }

    public void setGradeQueryText(JTextField gradeQueryText) {
        this.gradeQueryText = gradeQueryText;
    }

    public JButton getGradeQueryButton() {
        return gradeQueryButton;
    }

    public void setGradeQueryButton(JButton gradeQueryButton) {
        this.gradeQueryButton = gradeQueryButton;
    }

    public JButton getGradeUpdateButton() {
        return gradeUpdateButton;
    }

    public void setGradeUpdateButton(JButton gradeUpdateButton) {
        this.gradeUpdateButton = gradeUpdateButton;
    }

    public JButton getGradeAddButton() {
        return gradeAddButton;
    }

    public void setGradeAddButton(JButton gradeAddButton) {
        this.gradeAddButton = gradeAddButton;
    }

    public JButton getGradeDeleteButton() {
        return gradeDeleteButton;
    }

    public void setGradeDeleteButton(JButton gradeDeleteButton) {
        this.gradeDeleteButton = gradeDeleteButton;
    }
}
