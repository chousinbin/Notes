package com.SinbinZhou.JavaLab.Demo.Listener;

import com.SinbinZhou.JavaLab.Demo.Controller.AddPartController;
import com.SinbinZhou.JavaLab.Demo.Model.Production;
import com.SinbinZhou.JavaLab.Demo.View.AddPartView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: InsertListener
 * @UserName: SinBin
 * @date: 2023-07-07 17:47
 * @Description:
 */
public class AddPartListener implements ActionListener {
    AddPartView addPartView;

    public AddPartListener(AddPartView addPartView) {
        this.addPartView = addPartView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addPartView.getConfirmButton()) {
            /*
            接收插入信息, 调用JDBC
             */
            String name = addPartView.getNameText().getText();
            String factory = addPartView.getProductionFactoryText().getText();
            String address = addPartView.getProductionPlaceText().getText();
            String productionDate = addPartView.getProductionDateText().getText();
            String expirationDate = addPartView.getExpirationDateText().getText();
            String purchasePriceString = addPartView.getPurchasePriceText().getText();
            String purchaseQuantityString = addPartView.getPurchaseQuantityText().getText();
            String salePriceString = addPartView.getSalePriceText().getText();

            if(name == null || "".equals(name.trim()) ||
                    factory == null || "".equals(factory.trim()) ||
                    address == null || "".equals(address.trim()) ||
                    productionDate == null || "".equals(productionDate.trim()) ||
                    expirationDate == null || "".equals(expirationDate.trim()) ||
                    purchasePriceString == null || "".equals(purchasePriceString.trim()) ||
                    purchaseQuantityString == null || "".equals(purchaseQuantityString.trim()) ||
                    salePriceString == null || "".equals(salePriceString.trim()) ) {
                JOptionPane.showMessageDialog(addPartView, "信息不能为空");
                return;
            }

            double purchasePrice = Double.parseDouble(purchasePriceString);
            int purchaseQuantity = Integer.parseInt(purchaseQuantityString);
            double salePrice = Double.parseDouble(salePriceString);


            Production production = new Production();
            production.setName(name);
            production.setFactory(factory);
            production.setAddress(address);
            production.setProductionDate(productionDate);
            production.setExpirationDate(expirationDate);
            production.setPurchasePrice(purchasePrice);
            production.setPurchaseQuantity(purchaseQuantity);
            production.setSalePrice(salePrice);
            boolean st = AddPartController.productionAdd(production);
            if(st == false) {
                JOptionPane.showMessageDialog(addPartView, "入库失败");
            } else {
                JOptionPane.showMessageDialog(addPartView, "入库成功");
                cleanInformation();
            }
        }
        if(e.getSource() == addPartView.getResetButton()) {
            cleanInformation();
        }
    }

    private void cleanInformation() {
        addPartView.getNameText().setText("");
        addPartView.getProductionFactoryText().setText("");
        addPartView.getProductionPlaceText().setText("");
        addPartView.getProductionDateText().setText("");
        addPartView.getExpirationDateText().setText("");
        addPartView.getPurchasePriceText().setText("");
        addPartView.getPurchaseQuantityText().setText("");
        addPartView.getSalePriceText().setText("");
    }
}
