package CETMS.Controller;

import CETMS.Model.MyTableModel;
import CETMS.Model.StudentModel;
import CETMS.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StudentManageController {
    public static MyTableModel studentQuery(MyTableModel myTableModel, String queryKey) {
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
                for(int i = 1; i <= 7; i++) {
                    dt.addElement(rs.getObject(i));
                }
                data.addElement(dt);
            }

            //向实体对象添加数据
            myTableModel.setDate(data);
            //向实体对象添加表头
            Vector<Object> columns = new Vector<>();
            columns.addElement("学生学号");
            columns.addElement("学生姓名");
            columns.addElement("学生性别");
            columns.addElement("学生学校");
            columns.addElement("学生学院");
            columns.addElement("学生专业");
            columns.addElement("学生班级");
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

    private static String getSql(String queryKey) {
        String sql;
        if(queryKey == null) {
            sql = "select student_id, student_name, student_sex, " +
                    "student_school, student_academy, student_major, student_class " +
                    "from student";
        } else {
            sql = "select student_id, student_name, student_sex, " +
                    "student_school, student_academy, student_major, student_class " +
                    "from student WHERE " +
                    "student_id LIKE '%" + queryKey + "%' OR " +
                    "student_name LIKE '%" + queryKey + "%' OR " +
                    "student_sex LIKE '%" + queryKey + "%' OR " +
                    "student_school LIKE '%" + queryKey + "%' OR " +
                    "student_academy LIKE '%" + queryKey + "%' OR " +
                    "student_major LIKE '%" + queryKey + "%' OR " +
                    "student_class LIKE '%" + queryKey + "%'";
        }
        return sql;
    }
    public static boolean studentAdd(StudentModel studentModel) {
        String sql = "INSERT INTO student " +
                "(student_id, student_name, student_sex, student_school, " +
                "student_academy, student_major, student_class, student_pwd) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, 111111)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, studentModel.getStudentId());
            ps.setString(2, studentModel.getStudentName());
            ps.setString(3, studentModel.getStudentSex());
            ps.setString(4, studentModel.getStudentSchool());
            ps.setString(5, studentModel.getStudentAcademy());
            ps.setString(6, studentModel.getStudentMajor());
            ps.setString(7, studentModel.getStudentClass());
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
    public static void studentDelete(String studentId) {
        String sql = "DELETE FROM student WHERE student_id = " + studentId +"";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("发生异常");
            e.printStackTrace();
        } finally {
            DBUtil.closePs(ps);
            DBUtil.closeConnection(conn);
        }
    }
    //更新学生
    public static boolean studentUpdate(StudentModel studentModel) {
        String sql = "UPDATE student " +
                "SET student_name=?, student_sex=?, student_school=?, student_academy=?, " +
                "student_major=?, student_class=? " +
                "WHERE student_id=?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, studentModel.getStudentName());
            ps.setString(2, studentModel.getStudentSex());
            ps.setString(3, studentModel.getStudentSchool());
            ps.setString(4, studentModel.getStudentAcademy());
            ps.setString(5, studentModel.getStudentMajor());
            ps.setString(6, studentModel.getStudentClass());
            ps.setString(7, studentModel.getStudentId());
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
