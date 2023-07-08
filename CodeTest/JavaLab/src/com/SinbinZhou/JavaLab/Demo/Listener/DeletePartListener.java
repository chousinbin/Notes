package com.SinbinZhou.JavaLab.Demo.Listener;

import com.SinbinZhou.JavaLab.Demo.Jdbc.DeleteQuery;
import com.SinbinZhou.JavaLab.Demo.Model.TableModel;
import com.SinbinZhou.JavaLab.Demo.View.DeletePart;
import com.SinbinZhou.JavaLab.Demo.View.MyJTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * @ClassName: DeletePartListener
 * @UserName: SinBin
 * @date: 2023-07-07 22:05
 * @Description:
 */
public class DeletePartListener implements ActionListener {
    DeletePart deletePart;

    public DeletePartListener(DeletePart deletePart) {
        this.deletePart = deletePart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deletePart.getQueryProductButton()) {
            /*
            查询按钮触发事件, 得到商品模糊名称
            向数据库中查询符合条件商品
            把数据添加到table中, 再把table添加到该对象的scrollPane中
             */
            String key = deletePart.getQueryProductText().getText();
            //关键词为空, 不执行
            if(key == null || "".equals(key.trim())) {
                return;
            }
            //执行查询操作
            TableModel tableModel = DeleteQuery.query(key, new TableModel());
            //把表格实体放到Table中
            MyJTable table = new MyJTable(tableModel);
            deletePart.getScrollPane().setViewportView(table);

        }
        if(e.getSource() == deletePart.getSettlementButton()) {
            /*
            结算按钮触发事件, 得到商品id和数量
            从数据库减少库存, 记得判断库存是否充足
            返回总金额到文本框
             */
            String totalPrice = "";
            deletePart.getTotalPriceText().setText(totalPrice);
        }
    }
}
