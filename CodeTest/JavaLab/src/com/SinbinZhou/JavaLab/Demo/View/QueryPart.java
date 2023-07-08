package com.SinbinZhou.JavaLab.Demo.View;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: QueryPart
 * @UserName: SinBin
 * @date: 2023-07-07 19:41
 * @Description:
 */
public class QueryPart extends JPanel {
    JPanel topPanel;
    JPanel centerPanel;
    JLabel searchLabel;
    JScrollPane jScrollPane;
    JTextField searchText;
    JButton searchButton;
    SpringLayout springLayout = new SpringLayout();

    public QueryPart() {
        setLayout(new BorderLayout());
        //北部分组件添加
        topPanel = new JPanel(springLayout);
        searchLabel = new JLabel("模糊搜索");
        searchText = new JTextField();
        searchButton = new JButton("搜索");
        topPanel.add(searchLabel);
        topPanel.add(searchText);
        topPanel.add(searchButton);
        add(topPanel, BorderLayout.NORTH);
        //中间部分组件添加
        centerPanel = new JPanel(new BorderLayout());
        jScrollPane = new JScrollPane();
        centerPanel.add(jScrollPane);
        add(centerPanel, BorderLayout.CENTER);
        //字体大小设置
        Font font = new Font("宋体", Font.PLAIN, 50);
        Dimension dimension = new Dimension(500, 60);
        searchLabel.setFont(font);
        searchText.setFont(font);
        searchButton.setFont(font);
        searchText.setPreferredSize(dimension);
        //北部优化格式
        init_Top();
        //中部优化格式
        init_Center();


    }

    private void init_Top() {
        topPanel.setPreferredSize(new Dimension(0, 300));

        Spring tempWidth = Spring.sum(Spring.width(searchLabel),
                Spring.sum(Spring.width(searchText),
                        Spring.sum(Spring.width(searchButton),
                                Spring.constant(40))));
        int offSetX = tempWidth.getValue() / 2;

        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, searchLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, topPanel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, searchLabel, 150,
                SpringLayout.NORTH, topPanel);

        springLayout.putConstraint(SpringLayout.WEST, searchText, 20,
                SpringLayout.EAST, searchLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, searchText,0,
                SpringLayout.VERTICAL_CENTER, searchLabel);

        springLayout.putConstraint(SpringLayout.WEST, searchButton, 20,
                SpringLayout.EAST, searchText);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, searchButton, 0,
                SpringLayout.VERTICAL_CENTER, searchLabel);
    }

    private void init_Center() {
        centerPanel.setPreferredSize(new Dimension(0, 1000));
    }
}
