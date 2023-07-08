package com.SinbinZhou.JavaLab.Demo.Jdbc;

import com.SinbinZhou.JavaLab.Demo.Model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName: VerifyAccount
 * @UserName: SinBin
 * @date: 2023-07-08 10:55
 * @Description:
 */
public class AccountVerify {
    public static boolean accountVerify(Account account) {
        String sql = "select password from user where usrName = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConnection();
            if(conn == null) {
                return false;
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getUsrName());
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String pwd = resultSet.getString(1);
                if(account.getPwd().equals(pwd)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return false;
    }
}
