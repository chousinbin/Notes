package com.SinbinZhou.JavaLab.Demo.Listener;

import com.SinbinZhou.JavaLab.Demo.Jdbc.ProductionAdd;
import com.SinbinZhou.JavaLab.Demo.Model.Production;
import com.SinbinZhou.JavaLab.Demo.View.AddPart;

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
    AddPart addPart;

    public AddPartListener(AddPart addPart) {
        this.addPart = addPart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addPart.getConfirmButton()) {
            /*
            接收插入信息, 调用JDBC
             */
            String name = addPart.getNameText().getText();
            String factory = addPart.getProductionFactoryText().getText();
            String address = addPart.getProductionPlaceText().getText();
            String productionDate = addPart.getProductionDateText().getText();
            String expirationDate = addPart.getExpirationDateText().getText();
            String purchasePriceString = addPart.getPurchasePriceText().getText();
            String purchaseQuantityString = addPart.getPurchaseQuantityText().getText();
            String salePriceString = addPart.getSalePriceText().getText();

            if(name == null || "".equals(name.trim()) ||
                    factory == null || "".equals(factory.trim()) ||
                    address == null || "".equals(address.trim()) ||
                    productionDate == null || "".equals(productionDate.trim()) ||
                    expirationDate == null || "".equals(expirationDate.trim()) ||
                    purchasePriceString == null || "".equals(purchasePriceString.trim()) ||
                    purchaseQuantityString == null || "".equals(purchaseQuantityString.trim()) ||
                    salePriceString == null || "".equals(salePriceString.trim()) ) {
                JOptionPane.showMessageDialog(addPart, "信息不能为空");
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
            boolean st = ProductionAdd.productionAdd(production);
            if(st == false) {
                JOptionPane.showMessageDialog(addPart, "入库失败");
            } else {
                JOptionPane.showMessageDialog(addPart, "入库成功");
                cleanInformation();
            }
        }
        if(e.getSource() == addPart.getResetButton()) {
            cleanInformation();
        }
    }

    private void cleanInformation() {
        addPart.getNameText().setText("");
        addPart.getProductionFactoryText().setText("");
        addPart.getProductionPlaceText().setText("");
        addPart.getProductionDateText().setText("");
        addPart.getExpirationDateText().setText("");
        addPart.getPurchasePriceText().setText("");
        addPart.getPurchaseQuantityText().setText("");
        addPart.getSalePriceText().setText("");
    }
}
