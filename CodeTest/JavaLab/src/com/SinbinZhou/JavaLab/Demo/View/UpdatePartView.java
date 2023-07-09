package com.SinbinZhou.JavaLab.Demo.View;

import com.SinbinZhou.JavaLab.Demo.Listener.UpdatePartListener;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: UpdatePart
 * @UserName: SinBin
 * @date: 2023-07-07 19:41
 * @Description:
 */
public class UpdatePartView extends JPanel {
    private JPanel westPanel;
    private JPanel centerPanel;
    private JScrollPane jScrollPane;
    private MyJTable myJTable;

    private JButton updateButton;

    private JTextField nameText;
    private JTextField productionFactoryText;
    private JTextField productionPlaceText;
    private JTextField productionDateText;
    private JTextField expirationDateText;
    private JTextField purchasePriceText;
    private JTextField purchaseQuantityText;
    private JTextField salePriceText;

    private JLabel nameLabel;
    private JLabel productionFactoryLabel;
    private JLabel productionPlaceLabel;
    private JLabel productionDateLabel;
    private JLabel expirationDateLabel;
    private JLabel purchasePriceLabel;
    private JLabel purchaseQuantityLabel;
    private JLabel salePriceLabel;

    private JButton searchButton;

    UpdatePartListener listener = new UpdatePartListener(this);

    public UpdatePartView() {
        setLayout(new BorderLayout());
        westPanel = new JPanel();
        centerPanel = new JPanel();

        initWestPanel();
        initCenterPanel();

        add(westPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

    }



    private void initWestPanel() {
        westPanel.setPreferredSize(new Dimension(880,1600));
        SpringLayout springLayout = new SpringLayout();
        westPanel.setLayout(springLayout);


        Font font = new Font("宋体", Font.PLAIN, 36);
        Dimension dimension = new Dimension(300, 50);

        nameLabel = new JLabel("药品名称");
        nameLabel.setFont(font);
        productionFactoryLabel = new JLabel("生产厂家");
        productionFactoryLabel.setFont(font);
        productionPlaceLabel = new JLabel("生产地址");
        productionPlaceLabel.setFont(font);
        productionDateLabel = new JLabel("生产日期");
        productionDateLabel.setFont(font);
        expirationDateLabel = new JLabel("有效期");
        expirationDateLabel.setFont(font);
        purchasePriceLabel = new JLabel("进货价格");
        purchasePriceLabel.setFont(font);
        purchaseQuantityLabel = new JLabel("进货数量");
        purchaseQuantityLabel.setFont(font);
        salePriceLabel = new JLabel("售价");
        salePriceLabel.setFont(font);

        nameText = new JTextField();
        nameText.setPreferredSize(dimension);
        nameText.setFont(font);
        productionFactoryText = new JTextField();
        productionFactoryText.setPreferredSize(dimension);
        productionFactoryText.setFont(font);
        productionPlaceText = new JTextField();
        productionPlaceText.setPreferredSize(dimension);
        productionPlaceText.setFont(font);
        productionDateText = new JTextField();
        productionDateText.setPreferredSize(dimension);
        productionDateText.setFont(font);
        expirationDateText = new JTextField();
        expirationDateText.setPreferredSize(dimension);
        expirationDateText.setFont(font);
        purchasePriceText = new JTextField();
        purchasePriceText.setPreferredSize(dimension);
        purchasePriceText.setFont(font);
        purchaseQuantityText = new JTextField();
        purchaseQuantityText.setPreferredSize(dimension);
        purchaseQuantityText.setFont(font);
        salePriceText = new JTextField();
        salePriceText.setPreferredSize(dimension);
        salePriceText.setFont(font);

        westPanel.add(nameLabel);
        Spring tempWidth = Spring.sum(Spring.sum(Spring.width(nameLabel), Spring.width(nameText)),
                Spring.constant(20));
        int offSetX = tempWidth.getValue() / 2;
        springLayout.putConstraint(SpringLayout.WEST, nameLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 300,
                SpringLayout.NORTH, westPanel);

        westPanel.add(nameText);
        springLayout.putConstraint(SpringLayout.WEST, nameText, 20,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, nameText, 0,
                SpringLayout.NORTH, nameLabel);

        westPanel.add(productionFactoryLabel);
        springLayout.putConstraint(SpringLayout.EAST, productionFactoryLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionFactoryLabel, 40,
                SpringLayout.SOUTH, nameLabel);

        westPanel.add(productionFactoryText);
        springLayout.putConstraint(SpringLayout.WEST, productionFactoryText, 20,
                SpringLayout.EAST, productionFactoryLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, productionFactoryText, 0,
                SpringLayout.VERTICAL_CENTER, productionFactoryLabel);

        westPanel.add(productionPlaceLabel);
        springLayout.putConstraint(SpringLayout.EAST, productionPlaceLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionPlaceLabel, 40,
                SpringLayout.SOUTH, productionFactoryLabel);

        westPanel.add(productionPlaceText);
        springLayout.putConstraint(SpringLayout.WEST, productionPlaceText, 20,
                SpringLayout.EAST, productionPlaceLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, productionPlaceText, 0,
                SpringLayout.VERTICAL_CENTER, productionPlaceLabel);

        westPanel.add(productionDateLabel);
        springLayout.putConstraint(SpringLayout.EAST, productionDateLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionDateLabel, 40,
                SpringLayout.SOUTH, productionPlaceLabel);

        westPanel.add(productionDateText);
        springLayout.putConstraint(SpringLayout.WEST, productionDateText, 20,
                SpringLayout.EAST, productionDateLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, productionDateText, 0,
                SpringLayout.VERTICAL_CENTER, productionDateLabel);

        westPanel.add(expirationDateLabel);
        springLayout.putConstraint(SpringLayout.EAST, expirationDateLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, expirationDateLabel, 40,
                SpringLayout.SOUTH, productionDateLabel);

        westPanel.add(expirationDateText);
        springLayout.putConstraint(SpringLayout.WEST, expirationDateText, 20,
                SpringLayout.EAST, expirationDateLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, expirationDateText, 0,
                SpringLayout.VERTICAL_CENTER, expirationDateLabel);

        westPanel.add(purchasePriceLabel);
        springLayout.putConstraint(SpringLayout.EAST, purchasePriceLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, purchasePriceLabel, 40,
                SpringLayout.SOUTH, expirationDateLabel);

        westPanel.add(purchasePriceText);
        springLayout.putConstraint(SpringLayout.WEST, purchasePriceText, 20,
                SpringLayout.EAST, purchasePriceLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, purchasePriceText, 0,
                SpringLayout.VERTICAL_CENTER, purchasePriceLabel);

        westPanel.add(purchaseQuantityLabel);
        springLayout.putConstraint(SpringLayout.EAST, purchaseQuantityLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, purchaseQuantityLabel, 40,
                SpringLayout.SOUTH, purchasePriceLabel);

        westPanel.add(purchaseQuantityText);
        springLayout.putConstraint(SpringLayout.WEST, purchaseQuantityText, 20,
                SpringLayout.EAST, purchaseQuantityLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, purchaseQuantityText, 0,
                SpringLayout.VERTICAL_CENTER, purchaseQuantityLabel);

        westPanel.add(salePriceLabel);
        springLayout.putConstraint(SpringLayout.EAST, salePriceLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, salePriceLabel, 40,
                SpringLayout.SOUTH, purchaseQuantityLabel);

        westPanel.add(salePriceText);
        springLayout.putConstraint(SpringLayout.WEST, salePriceText, 20,
                SpringLayout.EAST, salePriceLabel);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, salePriceText, 0,
                SpringLayout.VERTICAL_CENTER, salePriceLabel);




        updateButton = new JButton("修改信息");
        updateButton.setFont(font);
        updateButton.addActionListener(listener);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, updateButton, 300,
                SpringLayout.VERTICAL_CENTER, salePriceLabel);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, updateButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        westPanel.add(updateButton);



        searchButton = new JButton("查询");
        searchButton.setFont(font);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, searchButton, 100,
                SpringLayout.VERTICAL_CENTER, updateButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, searchButton, 0,
                SpringLayout.HORIZONTAL_CENTER, westPanel);
        westPanel.add(searchButton);
        searchButton.addActionListener(listener);

    }

    private void initCenterPanel() {
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setPreferredSize(new Dimension(2000, 1600));
        centerPanel.setBackground(Color.PINK);
        jScrollPane = new JScrollPane();
        centerPanel.add(jScrollPane);
        myJTable = new MyJTable();
        jScrollPane.setViewportView(myJTable);
        //表格添加选择监视器
        myJTable.getSelectionModel().addListSelectionListener(listener);

    }

    public MyJTable getMyJTable() {
        return myJTable;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public JTextField getProductionFactoryText() {
        return productionFactoryText;
    }

    public JTextField getProductionPlaceText() {
        return productionPlaceText;
    }

    public JTextField getProductionDateText() {
        return productionDateText;
    }

    public JTextField getExpirationDateText() {
        return expirationDateText;
    }

    public JTextField getPurchasePriceText() {
        return purchasePriceText;
    }

    public JTextField getPurchaseQuantityText() {
        return purchaseQuantityText;
    }

    public JTextField getSalePriceText() {
        return salePriceText;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
