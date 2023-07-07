package com.SinbinZhou.JavaLab.Demo.Listener;

import com.SinbinZhou.JavaLab.Demo.View.AddPart;

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

        }
        if(e.getSource() == addPart.getResetButton()) {
            addPart.getNameText().setText("");
            addPart.getProductionFactoryText().setText("");
            addPart.getProductionPlaceText().setText("");
            addPart.getBatchNumberText().setText("");
            addPart.getProductionDateText().setText("");
            addPart.getExpirationDateText().setText("");
            addPart.getPurchasePriceText().setText("");
            addPart.getPurchaseQuantityText().setText("");
        }
    }
}
