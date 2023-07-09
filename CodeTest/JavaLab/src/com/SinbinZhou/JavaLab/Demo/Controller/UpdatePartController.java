package com.SinbinZhou.JavaLab.Demo.Controller;

import com.SinbinZhou.JavaLab.Demo.Model.Production;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @ClassName: UpdatePartController
 * @UserName: SinBin
 * @date: 2023-07-09 15:54
 * @Description:
 */
public class UpdatePartController {
    public static void updateSelected(Production production) {
        String sql = "UPDATE product SET name=?, factory=?, address=?, productionDate=?, " +
                "expirationDate=?, purchasePrice=?, purchaseQuantity=?, salePrice=? " +
                "WHERE id=?";
        Connection conn = null;
        PreparedStatement ps = null;

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
            ps.setInt(9, production.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
    }
}
