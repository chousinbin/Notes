package CETMS.View;

import CETMS.Listener.GradeQueryListener;

import javax.swing.*;
import java.awt.*;

public class GradeQueryView extends JPanel {
    private SpringLayout springLayout;
    private JPanel topPanel;
    private JPanel downPanel;
    private JButton queryButton;
    private JScrollPane myScrollPane;
    private MyJTable myTable;
    private GradeQueryListener listener;
    private Font font;

    public GradeQueryView() {
        setLayout(new BorderLayout());
        createObject();
        addComponent();
        setTopPanelLayout();
        queryButton.addActionListener(listener);
    }

    private void setTopPanelLayout() {
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, queryButton,
                0, SpringLayout.HORIZONTAL_CENTER, topPanel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, queryButton,
                150, SpringLayout.NORTH, topPanel);
    }

    private void addComponent() {
        topPanel.add(queryButton);
        add(topPanel, BorderLayout.NORTH);
        myScrollPane.setViewportView(myTable);
        downPanel.add(myScrollPane);
        add(downPanel, BorderLayout.CENTER);
    }

    private void createObject() {
        springLayout = new SpringLayout();
        topPanel = new JPanel(springLayout);
        topPanel.setPreferredSize(new Dimension(0, 300));
        downPanel = new JPanel(new BorderLayout());
        downPanel.setPreferredSize(new Dimension(0, 1300));
        queryButton = new JButton("查询我的英语四六级成绩");
        myScrollPane = new JScrollPane();
        myTable = new MyJTable();
        font = new Font("宋体", Font.PLAIN, 36);
        queryButton.setFont(font);
        listener = new GradeQueryListener(this);
    }

    public JButton getQueryButton() {
        return queryButton;
    }

    public void setQueryButton(JButton queryButton) {
        this.queryButton = queryButton;
    }

    public MyJTable getMyTable() {
        return myTable;
    }

    public void setMyTable(MyJTable myTable) {
        this.myTable = myTable;
    }
}
