package CETMS.Controller;

import CETMS.Model.StudentModel;
import CETMS.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentLoginController {
    public static boolean accountVerify(StudentModel accountModel) {
        String sql = "select student_pwd from student where student_id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            conn = DBUtil.getConnection();
            if(conn == null) {
                return false;
            }

            ps = conn.prepareStatement(sql);
            ps.setString(1, accountModel.getStudentId());
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String pwd = resultSet.getString(1);
                if(accountModel.getStudentPwd().equals(pwd)) {
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
