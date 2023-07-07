package com.SinbinZhou.JavaLab.Demo.View;

import com.SinbinZhou.JavaLab.Demo.Listener.AddPartListener;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: InsertPart
 * @UserName: SinBin
 * @date: 2023-07-07 17:49
 * @Description:
 */
public class AddPart extends JPanel {
    private JButton confirmButton;
    private JButton resetButton;
    private JTextField nameText;
    private JTextField productionFactoryText;
    private JTextField productionPlaceText;
    private JTextField batchNumberText;
    private JTextField productionDateText;
    private JTextField expirationDateText;
    private JTextField purchasePriceText;
    private JTextField purchaseQuantityText;
    private JLabel nameLabel;
    private JLabel productionFactoryLabel;
    private JLabel productionPlaceLabel;
    private JLabel batchNumberLabel;
    private JLabel productionDateLabel;
    private JLabel expirationDateLabel;
    private JLabel purchasePriceLabel;
    private JLabel purchaseQuantityLabel;


    public AddPart() {
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);

        Font font = new Font("宋体", Font.PLAIN, 36);
        Dimension dimension = new Dimension(300, 50);

        nameLabel = new JLabel("药品名称");
        nameLabel.setFont(font);
        productionFactoryLabel = new JLabel("生产厂家");
        productionFactoryLabel.setFont(font);
        productionPlaceLabel = new JLabel("生产地址");
        productionPlaceLabel.setFont(font);
        batchNumberLabel = new JLabel("生产批号");
        batchNumberLabel.setFont(font);
        productionDateLabel = new JLabel("生产日期");
        productionDateLabel.setFont(font);
        expirationDateLabel = new JLabel("有效期");
        expirationDateLabel.setFont(font);
        purchasePriceLabel = new JLabel("进货价格");
        purchasePriceLabel.setFont(font);
        purchaseQuantityLabel = new JLabel("进货数量");
        purchaseQuantityLabel.setFont(font);

        nameText = new JTextField();
        nameText.setPreferredSize(dimension);
        nameText.setFont(font);
        productionFactoryText = new JTextField();
        productionFactoryText.setPreferredSize(dimension);
        productionFactoryText.setFont(font);
        productionPlaceText = new JTextField();
        productionPlaceText.setPreferredSize(dimension);
        productionPlaceText.setFont(font);
        batchNumberText = new JTextField();
        batchNumberText.setPreferredSize(dimension);
        batchNumberText.setFont(font);
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

        add(nameLabel);
        Spring tempWidth = Spring.sum(Spring.sum(Spring.width(nameLabel), Spring.width(nameText)),
                Spring.constant(20));
        int offSetX = tempWidth.getValue() / 2;
        springLayout.putConstraint(SpringLayout.WEST, nameLabel, -offSetX,
                SpringLayout.HORIZONTAL_CENTER, this);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 300,
                SpringLayout.NORTH, this);

        add(nameText);
        springLayout.putConstraint(SpringLayout.WEST, nameText, 20,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, nameText, 0,
                SpringLayout.NORTH, nameLabel);

        add(productionFactoryLabel);
        springLayout.putConstraint(SpringLayout.EAST, productionFactoryLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionFactoryLabel, 40,
                SpringLayout.SOUTH, nameLabel);

        add(productionFactoryText);
        springLayout.putConstraint(SpringLayout.WEST, productionFactoryText, 20,
                SpringLayout.EAST, productionFactoryLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionFactoryText, 0,
                SpringLayout.NORTH, productionFactoryLabel);

        add(productionPlaceLabel);
        springLayout.putConstraint(SpringLayout.EAST, productionPlaceLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionPlaceLabel, 40,
                SpringLayout.SOUTH, productionFactoryLabel);

        add(productionPlaceText);
        springLayout.putConstraint(SpringLayout.WEST, productionPlaceText, 20,
                SpringLayout.EAST, productionPlaceLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionPlaceText, 0,
                SpringLayout.NORTH, productionPlaceLabel);

        add(batchNumberLabel);
        springLayout.putConstraint(SpringLayout.EAST, batchNumberLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, batchNumberLabel, 40,
                SpringLayout.SOUTH, productionPlaceLabel);

        add(batchNumberText);
        springLayout.putConstraint(SpringLayout.WEST, batchNumberText, 20,
                SpringLayout.EAST, batchNumberLabel);
        springLayout.putConstraint(SpringLayout.NORTH, batchNumberText, 0,
                SpringLayout.NORTH, batchNumberLabel);

        add(productionDateLabel);
        springLayout.putConstraint(SpringLayout.EAST, productionDateLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionDateLabel, 40,
                SpringLayout.SOUTH, batchNumberLabel);

        add(productionDateText);
        springLayout.putConstraint(SpringLayout.WEST, productionDateText, 20,
                SpringLayout.EAST, productionDateLabel);
        springLayout.putConstraint(SpringLayout.NORTH, productionDateText, 0,
                SpringLayout.NORTH, productionDateLabel);

        add(expirationDateLabel);
        springLayout.putConstraint(SpringLayout.EAST, expirationDateLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, expirationDateLabel, 40,
                SpringLayout.SOUTH, productionDateLabel);

        add(expirationDateText);
        springLayout.putConstraint(SpringLayout.WEST, expirationDateText, 20,
                SpringLayout.EAST, expirationDateLabel);
        springLayout.putConstraint(SpringLayout.NORTH, expirationDateText, 0,
                SpringLayout.NORTH, expirationDateLabel);

        add(purchasePriceLabel);
        springLayout.putConstraint(SpringLayout.EAST, purchasePriceLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, purchasePriceLabel, 40,
                SpringLayout.SOUTH, expirationDateLabel);

        add(purchasePriceText);
        springLayout.putConstraint(SpringLayout.WEST, purchasePriceText, 20,
                SpringLayout.EAST, purchasePriceLabel);
        springLayout.putConstraint(SpringLayout.NORTH, purchasePriceText, 0,
                SpringLayout.NORTH, purchasePriceLabel);

        add(purchaseQuantityLabel);
        springLayout.putConstraint(SpringLayout.EAST, purchaseQuantityLabel, 0,
                SpringLayout.EAST, nameLabel);
        springLayout.putConstraint(SpringLayout.NORTH, purchaseQuantityLabel, 40,
                SpringLayout.SOUTH, purchasePriceLabel);

        add(purchaseQuantityText);
        springLayout.putConstraint(SpringLayout.WEST, purchaseQuantityText, 20,
                SpringLayout.EAST, purchaseQuantityLabel);
        springLayout.putConstraint(SpringLayout.NORTH, purchaseQuantityText, 0,
                SpringLayout.NORTH, purchaseQuantityLabel);

        AddPartListener listener = new AddPartListener(this);

        confirmButton = new JButton("确认入库");
        confirmButton.setFont(font);
        confirmButton.addActionListener(listener);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, confirmButton, 300,
                SpringLayout.VERTICAL_CENTER, purchaseQuantityText);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, confirmButton, 0,
                SpringLayout.HORIZONTAL_CENTER, this);
        add(confirmButton);

        resetButton = new JButton("重置信息");
        resetButton.setFont(font);
        resetButton.addActionListener(listener);
        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, resetButton, 100,
                SpringLayout.VERTICAL_CENTER, confirmButton);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, resetButton, 0,
                SpringLayout.HORIZONTAL_CENTER, this);
        add(resetButton);
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JButton getResetButton() {
        return resetButton;
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

    public JTextField getBatchNumberText() {
        return batchNumberText;
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
}