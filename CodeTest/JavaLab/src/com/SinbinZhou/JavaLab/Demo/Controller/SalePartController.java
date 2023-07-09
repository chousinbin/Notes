package com.SinbinZhou.JavaLab.Demo.Controller;

import com.SinbinZhou.JavaLab.Demo.Model.Production;
import com.SinbinZhou.JavaLab.Demo.Model.MyTableModel;

import java.sql.*;
import java.util.Vector;

/**
 * @ClassName: Query
 * @UserName: SinBin
 * @date: 2023-07-08 21:50
 * @Description:
 * 用于销售界面模糊查询
 * 模糊搜索, 返回表格实体, 包含表头和数据
 * ?返回类型应该修改为实体
 * 表格模式应该根据实体设置date和columns
 */
public class SalePartController {

    public static MyTableModel query(String key, MyTableModel myTableModel) {
        //模糊查询关键词, 不显示进价
        String sql = "SELECT id, name, factory, address, productionDate, " +
                "expirationDate, purchaseQuantity, salePrice" +
                " FROM product WHERE " +
                "name LIKE '%" + key + "%' OR " +
                "factory LIKE '%" + key + "%' OR " +
                "address LIKE '%" + key + "%'";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Vector<Vector<Object>> data = new Vector<>();

        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //数据库中无结果直接返回null

            while(rs.next()) {
                Vector<Object> dt = new Vector<>();
                for (int i = 1; i <= 8; i++) {
                    dt.addElement(rs.getObject(i));
                }
                data.addElement(dt);
            }

            //向实体对象添加数据
            myTableModel.setDate(data);
            //向实体对象添加表头
            Vector<Object> columns = new Vector<>();
            columns.addElement("id");
            columns.addElement("药品名称");
            columns.addElement("生产厂家");
            columns.addElement("生产地址");
            columns.addElement("生产日期");
            columns.addElement("有效期");
            columns.addElement("库存数量");
            columns.addElement("售价");
            myTableModel.setColumns(columns);

            myTableModel.setDataVector(data, columns);
            return myTableModel;
        } catch (SQLException e) {
            System.out.println("发生异常");
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeSt(st);
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    //根据id查询商品, 返回该id商品的库存和售价, 返回类型为Product
    public static Production idQuery(Production production) {
        int qid = production.getId();
        String sql = "select purchaseQuantity, salePrice from product where id = " + qid + "";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                production.setPurchaseQuantity(rs.getInt(1));
                production.setSalePrice(rs.getDouble(2));
            }
            return production;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    public static void update(Production production) {
        String sql = "update product set purchaseQuantity = " +
                production.getPurchaseQuantity() + " " +
                "where id = " + production.getId() + "";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
    }
}
