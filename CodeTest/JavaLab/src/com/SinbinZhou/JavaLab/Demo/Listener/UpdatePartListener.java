package com.SinbinZhou.JavaLab.Demo.Listener;

import com.SinbinZhou.JavaLab.Demo.Controller.StockPartController;
import com.SinbinZhou.JavaLab.Demo.Controller.UpdatePartController;
import com.SinbinZhou.JavaLab.Demo.Model.MyTableModel;
import com.SinbinZhou.JavaLab.Demo.Model.Production;
import com.SinbinZhou.JavaLab.Demo.View.MyJTable;
import com.SinbinZhou.JavaLab.Demo.View.UpdatePartView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: UpdatePartListener
 * @UserName: SinBin
 * @date: 2023-07-09 15:53
 * @Description:
 */
public class UpdatePartListener implements ActionListener , ListSelectionListener {
    UpdatePartView updatePartView;
    Production production;

    public UpdatePartListener(UpdatePartView updatePartView) {
        this.updatePartView = updatePartView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == updatePartView.getUpdateButton()) {
            //判断是否已经选中要修改的信息
            if(production == null) {
                return;
            }
            //获取文本框数据
            String name = updatePartView.getNameText().getText();
            String factory = updatePartView.getProductionFactoryText().getText();
            String address = updatePartView.getProductionPlaceText().getText();
            String productionDate = updatePartView.getProductionDateText().getText();
            String expirationDate = updatePartView.getExpirationDateText().getText();
            String purchasePrice = updatePartView.getPurchasePriceText().getText();
            String purchaseNum = updatePartView.getPurchaseQuantityText().getText();
            String salePrice = updatePartView.getSalePriceText().getText();
            //判断文本框内容是否为空
            if(name == null || "".equals(name.trim()) ||
                    factory == null || "".equals(factory.trim()) ||
                    address == null || "".equals(address.trim()) ||
                    productionDate == null || "".equals(productionDate.trim()) ||
                    expirationDate == null || "".equals(expirationDate.trim()) ||
                    purchasePrice == null || "".equals(purchasePrice.trim()) ||
                    purchaseNum == null || "".equals(purchaseNum.trim()) ||
                    salePrice == null || "".equals(salePrice.trim()) ) {
                return;
            }
            //文本框数据到入到实体
            production.setName(name);
            production.setFactory(factory);
            production.setAddress(address);
            production.setProductionDate(productionDate);
            production.setExpirationDate(expirationDate);
            production.setPurchasePrice(Double.parseDouble(purchasePrice));
            production.setPurchaseQuantity(Integer.parseInt(purchaseNum));
            production.setSalePrice(Double.parseDouble(salePrice));

            //根据id和更新的实体
            UpdatePartController.updateSelected(production);
            //修改完成之后, 查询最新数据库, 把结果显示到JTable中
            MyTableModel myTableModel = StockPartController.stockQueryAll(new MyTableModel());
            updatePartView.getMyJTable().setMyTableModel(myTableModel);
        }

        if(e.getSource() == updatePartView.getSearchButton()) {
            //查询数据库, 返回列表模型, 添加到面板
            MyTableModel myTableModel = StockPartController.stockQueryAll(new MyTableModel());
            updatePartView.getMyJTable().setMyTableModel(myTableModel);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        MyJTable myJTable = updatePartView.getMyJTable();
        int selectedRom = myJTable.getSelectedRow();

        if(selectedRom != -1)
        {
            //把选中行的数据提取到实体对象中
            production = new Production();
            production.setId((int)myJTable.getValueAt(selectedRom, 0));
            production.setName((String)myJTable.getValueAt(selectedRom, 1));
            production.setFactory((String) myJTable.getValueAt(selectedRom, 2));
            production.setAddress((String) myJTable.getValueAt(selectedRom, 3));
            production.setProductionDate((String) myJTable.getValueAt(selectedRom, 4));
            production.setExpirationDate((String) myJTable.getValueAt(selectedRom, 5));
            production.setPurchasePrice((double)myJTable.getValueAt(selectedRom, 6));
            production.setPurchaseQuantity((int)myJTable.getValueAt(selectedRom, 7));
            production.setSalePrice((double)myJTable.getValueAt(selectedRom, 8));
            //实体对象存放的选中的数据 显示到 修改框
            updatePartView.getNameText().setText(production.getName());
            updatePartView.getProductionFactoryText().setText(production.getFactory());
            updatePartView.getProductionPlaceText().setText(production.getAddress());
            updatePartView.getProductionDateText().setText(production.getProductionDate());
            updatePartView.getExpirationDateText().setText(production.getExpirationDate());
            updatePartView.getPurchasePriceText().setText(production.getPurchasePrice() + "");
            updatePartView.getPurchaseQuantityText().setText(production.getPurchaseQuantity() + "");
            updatePartView.getSalePriceText().setText(production.getSalePrice() + "");
        }
    }
}
