package CETMS.Controller;

import CETMS.Model.MyTableModel;
import CETMS.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class GradeQueryController {
    public static MyTableModel gradeQuery(String studentId) {
        String sql = "select test_date, test_type, student_id, " +
                "listening_grade, reading_grade, writing_grade, sum_grade " +
                "from grade " +
                "where student_id = " + studentId + "";
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
            MyTableModel myTableModel = new MyTableModel();
            myTableModel.setDate(data);
            //向实体对象添加表头
            Vector<Object> columns = new Vector<>();
            columns.addElement("考试日期");
            columns.addElement("考试类型");
            columns.addElement("考生学号");
            columns.addElement("听力成绩");
            columns.addElement("阅读成绩");
            columns.addElement("写译成绩");
            columns.addElement("总成绩");
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
}
