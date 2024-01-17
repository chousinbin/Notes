package CETMS.Controller;

import CETMS.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PwdUpdateController {
    public static boolean pwdUpdate(String userType, String userId, String newPwd) {
        String sql = "UPDATE " + userType + " SET " +
                userType + "_pwd = ? " +
                "WHERE " + userType + "_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newPwd);
            ps.setString(2, userId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return true;
    }
}
