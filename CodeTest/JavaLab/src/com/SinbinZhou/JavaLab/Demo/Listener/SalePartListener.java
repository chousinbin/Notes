package com.SinbinZhou.JavaLab.Demo.Listener;

import com.SinbinZhou.JavaLab.Demo.Model.Production;
import com.SinbinZhou.JavaLab.Demo.Model.MyTableModel;
import com.SinbinZhou.JavaLab.Demo.View.SalePartController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: DeletePartListener
 * @UserName: SinBin
 * @date: 2023-07-07 22:05
 * @Description:
 */
public class SalePartListener implements ActionListener {
    SalePartController salePartController;
    MyTableModel myTableModel;
    String key;

    public SalePartListener(SalePartController salePartController) {
        this.salePartController = salePartController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == salePartController.getQueryProductButton()) {
            /*
            查询按钮触发事件, 得到商品模糊名称
            向数据库中查询符合条件商品
            把数据添加到table中, 再把table添加到该对象的scrollPane中
             */
            key = salePartController.getQueryProductText().getText();
            //关键词为空, 不执行
            if(key == null || "".equals(key.trim())) {
                return;
            }
            //执行查询操作
            myTableModel = com.SinbinZhou.JavaLab.Demo.Controller.SalePartController.query(key, new MyTableModel());
            //把表格实体放到Table中
            salePartController.getMyJTable().setMyTableModel(myTableModel);
        }
        if(e.getSource() == salePartController.getSettlementButton()) {
            /*
            结算按钮触发事件, 得到商品id和数量
            从数据库减少库存, 记得判断库存是否充足
            返回总金额到文本框
             */
            String idStr = salePartController.getProductIDText().getText();
            String numStr = salePartController.getSealNumberText().getText();
            //输入不完整 直接退出
            if(idStr == null || "".equals(idStr.trim()) ||
            numStr == null || "".equals(numStr.trim())) {
                return;
            }
            //把id传到实体
            int id = Integer.parseInt(idStr);
            int num = Integer.parseInt(numStr);
            Production production = new Production();
            production.setId(id);
            //执行查询传入带id的实体, 返回带出售价格和库存的实体
            production = com.SinbinZhou.JavaLab.Demo.Controller.SalePartController.idQuery(production);
            if(production == null) {
                return;
            }
            //查到了该id商品, 提取库存和售价
            int numQuery = production.getPurchaseQuantity();
            double priceQuery = production.getSalePrice();
            //判断请求数量是否库存满足
            if(numQuery < num) {
                System.out.println("库存不足, 出库失败");
                return;
            }
            //满足计算价格
            String totalPrice = "应收: " + num * priceQuery;
            salePartController.getTotalPriceText().setText(totalPrice);
            //更新数据库减去库存
            production.setPurchaseQuantity(numQuery - num);
            com.SinbinZhou.JavaLab.Demo.Controller.SalePartController.update(production);
            //重新显示模糊查询
            myTableModel = com.SinbinZhou.JavaLab.Demo.Controller.SalePartController.query(key, new MyTableModel());
            salePartController.getMyJTable().setMyTableModel(myTableModel);
        }
    }
}
