package CETMS.Controller;

import CETMS.Model.MyTableModel;
import CETMS.Model.TeacherModel;
import CETMS.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TeacherManageController {
    // 教师查询方法
    public static MyTableModel teacherQuery(MyTableModel myTableModel, String queryKey) {
        String sql = getSql(queryKey);
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            Vector<Vector<Object>> data = new Vector<>();
            while(rs.next()) {
                Vector<Object> dt = new Vector<>();
                for(int i = 1; i <= 4; i++) {
                    dt.addElement(rs.getObject(i));
                }
                data.addElement(dt);
            }

            // 向实体对象添加数据
            myTableModel.setDate(data);
            // 向实体对象添加表头
            Vector<Object> columns = new Vector<>();
            columns.addElement("教师工号");
            columns.addElement("教师姓名");
            columns.addElement("教师性别");
            columns.addElement("教师电话");
            myTableModel.setColumns(columns);
            myTableModel.setDataVector(data, columns);
            return myTableModel;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
        return null;
    }

    // 获取SQL查询语句
    private static String getSql(String queryKey) {
        String sql;
        if(queryKey == null || queryKey == "") {
            sql = "select teacher_id, teacher_name, teacher_sex, teacher_phone " +
                    "from teacher";
        } else {
            sql = "select teacher_id, teacher_name, teacher_sex, teacher_phone " +
                    "from teacher " +
                    "WHERE " +
                    "teacher_id LIKE '%" + queryKey + "%' OR " +
                    "teacher_name LIKE '%" + queryKey + "%' OR " +
                    "teacher_sex LIKE '%" + queryKey + "%' OR " +
                    "teacher_phone LIKE '%" + queryKey + "%'";
        }
        return sql;
    }

    // 添加教师信息
    public static boolean teacherAdd(TeacherModel teacherModel) {
        String sql = "INSERT INTO teacher " +
                "(teacher_id, teacher_name, teacher_sex, teacher_phone, teacher_pwd) " +
                "VALUES (?, ?, ?, ?, 111111)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, teacherModel.getTeacherId());
            ps.setString(2, teacherModel.getTeacherName());
            ps.setString(3, teacherModel.getTeacherSex());
            ps.setString(4, teacherModel.getTeacherPhone());
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

    // 删除教师信息
    public static void teacherDelete(String teacherId) {
        String sql = "DELETE FROM teacher " +
                "WHERE teacher_id = '" + teacherId + "'";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
    }

    // 更新教师信息
    public static boolean teacherUpdate(TeacherModel teacherModel) {
        String sql = "UPDATE teacher " +
                "SET teacher_name=?, teacher_sex=?, teacher_phone=? " +
                "WHERE teacher_id=?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, teacherModel.getTeacherName());
            ps.setString(2, teacherModel.getTeacherSex());
            ps.setString(3, teacherModel.getTeacherPhone());
            ps.setString(4, teacherModel.getTeacherId());
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

