package com.SinbinZhou.JavaLab.Demo.Jdbc;

import com.SinbinZhou.JavaLab.Demo.Model.TableModel;

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
public class DeleteQuery {

    public static TableModel query(String key, TableModel tableModel) {
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
            tableModel.setDate(data);
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
            tableModel.setColumns(columns);

            tableModel.setDataVector(data, columns);
            return tableModel;
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
}
