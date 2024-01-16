package CETMS.Controller;

import CETMS.Model.AdminModel;
import CETMS.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginController {
    public static boolean accountVerify(AdminModel accountModel) {
        String sql = "select admin_pwd from admin where admin_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            conn = DBUtil.getConnection();
            if(conn == null) {
                return false;
            }

            ps = conn.prepareStatement(sql);
            ps.setString(1, accountModel.getAdminId());
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String pwd = resultSet.getString(1);
                if(accountModel.getAdminPwd().equals(pwd)) {
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