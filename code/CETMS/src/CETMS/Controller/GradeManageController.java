package CETMS.Controller;

import CETMS.Model.GradeModel;
import CETMS.Model.MyTableModel;
import CETMS.Util.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class GradeManageController {
    public static MyTableModel gradeQuery(MyTableModel myTableModel, String queryKey) {
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
                for(int i = 1; i <= 14; i++) {
                    dt.addElement(rs.getObject(i));
                }
                data.addElement(dt);
            }

            //向实体对象添加数据
            myTableModel.setDate(data);
            //向实体对象添加表头
            Vector<Object> columns = new Vector<>();
            columns.addElement("成绩序号");
            columns.addElement("考试日期");
            columns.addElement("考试类型");
            columns.addElement("考生学校");
            columns.addElement("考生学院");
            columns.addElement("考生专业");
            columns.addElement("考生班级");
            columns.addElement("考生学号");
            columns.addElement("考生姓名");
            columns.addElement("听力成绩");
            columns.addElement("阅读成绩");
            columns.addElement("写译成绩");
            columns.addElement("总成绩");
            columns.addElement("录入教师");
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
            sql = "SELECT grade_id, test_date, test_type, " +
                    "student_school, student_academy, student_major, " +
                    "student_class, grade.student_id, student_name, " +
                    "listening_grade, reading_grade, writing_grade, sum_grade, " +
                    "teacher_name " +
                    "FROM grade " +
                    "JOIN student ON student.student_id = grade.student_id " +
                    "JOIN teacher ON teacher.teacher_id = grade.teacher_id " +
                    "ORDER BY " +
                    "test_date ASC, test_type ASC, student_school ASC, student_academy ASC, " +
                    "student_major ASC, student_class ASC, grade.student_id ASC, sum_grade DESC";
        } else {
            sql = "SELECT grade_id, test_date, test_type, " +
                    "student_school, student_academy, student_major, " +
                    "student_class, grade.student_id, student_name, " +
                    "listening_grade, reading_grade, writing_grade, sum_grade, " +
                    "teacher_name " +
                    "FROM grade " +
                    "JOIN student ON student.student_id = grade.student_id " +
                    "JOIN teacher ON teacher.teacher_id = grade.teacher_id " +
                    "WHERE " +
                    "grade_id LIKE '%" + queryKey + "%' OR " +
                    "test_date LIKE '%" + queryKey + "%' OR " +
                    "test_type LIKE '%" + queryKey + "%' OR " +
                    "student_school LIKE '%" + queryKey + "%' OR " +
                    "student_academy LIKE '%" + queryKey + "%' OR " +
                    "student_major LIKE '%" + queryKey + "%' OR " +
                    "student_class LIKE '%" + queryKey + "%' OR " +
                    "grade.student_id LIKE '%" + queryKey + "%' OR " +
                    "student_name LIKE '%" + queryKey + "%' OR " +
                    "listening_grade LIKE '%" + queryKey + "%' OR " +
                    "reading_grade LIKE '%" + queryKey + "%' OR " +
                    "writing_grade LIKE '%" + queryKey + "%' OR " +
                    "sum_grade LIKE '%" + queryKey + "%' OR " +
                    "teacher_name LIKE '%" + queryKey + "%' " +
                    "ORDER BY " +
                    "test_date ASC, test_type ASC, student_school ASC, student_academy ASC, " +
                    "student_major ASC, student_class ASC, grade.student_id ASC, sum_grade DESC";
        }
        return sql;
    }
    public static boolean gradeAdd(GradeModel gradeModel) {
        String sql = "INSERT INTO grade " +
                "(test_date, test_type, student_id, teacher_id, " +
                "listening_grade, reading_grade, writing_grade, sum_grade) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, gradeModel.getTestDate());
            ps.setString(2, gradeModel.getTestType());
            ps.setString(3, gradeModel.getStudentId());
            ps.setString(4, gradeModel.getTeacherId());
            ps.setBigDecimal(5, BigDecimal.valueOf(gradeModel.getListeningGrade()));
            ps.setBigDecimal(6, BigDecimal.valueOf(gradeModel.getReadingGrade()));
            ps.setBigDecimal(7, BigDecimal.valueOf(gradeModel.getWritingGrade()));
            ps.setBigDecimal(8, BigDecimal.valueOf(gradeModel.getSumGrade()));
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
    public static void gradeDelete(int gradeId) {
        String sql = "DELETE FROM grade WHERE grade_id = " + gradeId +"";
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
    //更新成绩
    public static boolean gradeUpdate(GradeModel gradeModel) {
        String sql = "UPDATE grade " +
                "SET test_date=?, test_type=?, student_id=?, teacher_id=?, " +
                "listening_grade=?, reading_grade=?, writing_grade=?, sum_grade=? " +
                "WHERE grade_id=?";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, gradeModel.getTestDate());
            ps.setString(2, gradeModel.getTestType());
            ps.setString(3, gradeModel.getStudentId());
            ps.setString(4, gradeModel.getTeacherId());
            ps.setBigDecimal(5, BigDecimal.valueOf(gradeModel.getListeningGrade()));
            ps.setBigDecimal(6, BigDecimal.valueOf(gradeModel.getReadingGrade()));
            ps.setBigDecimal(7, BigDecimal.valueOf(gradeModel.getWritingGrade()));
            ps.setBigDecimal(8, BigDecimal.valueOf(gradeModel.getSumGrade()));
            ps.setInt(9, gradeModel.getGradeId());

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
