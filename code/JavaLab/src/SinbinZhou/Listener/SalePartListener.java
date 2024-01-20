package SinbinZhou.Listener;

import SinbinZhou.Controller.SalePartController;
import SinbinZhou.Model.MyTableModel;
import SinbinZhou.Model.ProductionModel;
import SinbinZhou.View.MyJOptionPane;
import SinbinZhou.View.SalePartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * @ClassName: DeletePartListener
 * @UserName: SinBin
 * @date: 2023-07-07 22:05
 * @Description:
 */
public class SalePartListener implements ActionListener {
    private SalePartView salePartView;
    private MyTableModel myTableModel;
    private String key;

    public SalePartListener(SalePartView salePartView) {
        this.salePartView = salePartView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //模糊查询事件
        if(e.getSource() == salePartView.getQueryProductButton()) {
            /*
            查询按钮触发事件, 得到商品模糊名称
            向数据库中查询符合条件商品
            把数据添加到table中, 再把table添加到该对象的scrollPane中
             */
            key = salePartView.getQueryProductText().getText();
            //关键词为空, 不执行
            if(key == null || "".equals(key.trim())) {
                return;
            }
            //执行查询操作
            myTableModel = SalePartController.query(key, new MyTableModel());
            //把表格实体放到Table中
            salePartView.getMyJTable().setMyTableModel(myTableModel);
        }
        //结算事件
        if(e.getSource() == salePartView.getSettlementButton()) {
            /*
            结算按钮触发事件, 得到商品id和数量
            从数据库减少库存, 记得判断库存是否充足
            返回总金额到文本框
             */
            String idStr = salePartView.getProductIDText().getText();
            String numStr = salePartView.getSealNumberText().getText();
            //输入不完整 直接退出
            if(idStr == null || "".equals(idStr.trim()) ||
            numStr == null || "".equals(numStr.trim())) {
                return;
            }
            //把id传到实体
            int id = Integer.parseInt(idStr);
            int num = Integer.parseInt(numStr);
            ProductionModel productionModel = new ProductionModel();
            productionModel.setId(id);
            //执行查询传入带id的实体, 返回带出售价格和库存的实体
            productionModel = SalePartController.idQuery(productionModel);
            if(productionModel == null) {
                return;
            }
            //查到了该id商品, 提取库存和售价
            int numQuery = productionModel.getPurchaseQuantity();
            double priceQuery = productionModel.getSalePrice();
            //判断请求数量是否库存满足
            if(numQuery < num) {
                MyJOptionPane.showMessageDialog(null, "库存不足", "提示");

                return;
            }
            //满足计算价格
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String result = decimalFormat.format(num * priceQuery);
            salePartView.getTotalPriceText().setText("应收: " + result);
            //更新数据库减去库存
            productionModel.setPurchaseQuantity(numQuery - num);
            SalePartController.update(productionModel);
            //重新显示模糊查询
            myTableModel = SalePartController.query(key, new MyTableModel());
            salePartView.getMyJTable().setMyTableModel(myTableModel);
        }
    }
}