package com.SinbinZhou.JavaLab.Demo.Jdbc;

import com.SinbinZhou.JavaLab.Demo.Model.Account;
import com.SinbinZhou.JavaLab.Demo.Model.Production;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName: ProductionAdd
 * @UserName: SinBin
 * @date: 2023-07-08 11:50
 * @Description:
 */
public class ProductionAdd {
    public static boolean productionAdd(Production production) {
        String sql = "insert into product values (null, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, production.getName());
            ps.setString(2, production.getFactory());
            ps.setString(3, production.getAddress());
            ps.setString(4, production.getProductionDate());
            ps.setString(5, production.getExpirationDate());
            ps.setDouble(6, production.getPurchasePrice());
            ps.setInt(7, production.getPurchaseQuantity());
            ps.setDouble(8, production.getSalePrice());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return true;
    }
}
