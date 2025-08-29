package controller;

import model.DB;
import model.Member;
import model.RewardRecord;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.text.SimpleDateFormat;


public class RewardRecordQuery extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String keyword = request.getParameter("keyword");

        String sql;
        if (keyword.isEmpty() || keyword.trim().isEmpty() || keyword.equals("")) {
            sql = "SELECT " +
             "    rr.record_id, " +
             "    m.member_id, " +
             "    m.member_name, " +
            "    m.member_phone, " +
             "    rr.record_type, " +
             "    rr.record_amount, " +
             "    rr.record_time " +
             "FROM reward_records rr " +
             "INNER JOIN members m ON rr.member_id = m.member_id " +
             "ORDER BY rr.record_time DESC";
        } else {
            sql = "SELECT " +
             "    rr.record_id, " +
             "    m.member_id, " +
             "    m.member_name, " +
            "    m.member_phone, " +
             "    rr.record_type, " +
             "    rr.record_amount, " +
             "    rr.record_time " +
             "FROM reward_records rr " +
             "INNER JOIN members m ON rr.member_id = m.member_id " +
             "WHERE " +
             "    m.member_name LIKE '%" + keyword + "%' OR " +
             "    m.member_id LIKE '%" + keyword + "%' OR " +
             "    m.member_phone LIKE '%" + keyword + "%'" + 
             "ORDER BY rr.record_time DESC;";
        }

        List<RewardRecord> rewardRecords = new ArrayList<>();
        try {
            DB db = new DB();

            ResultSet rs = db.excuteQ(sql);

            while (rs.next()) {
                RewardRecord rewardRecord = new RewardRecord(
                    rs.getInt(1),
                    rs.getInt(2), 
                    rs.getString(3), 
                    rs.getString(4),
                    rs.getString(5),
                    rs.getBigDecimal(6),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(rs.getTimestamp(7).getTime()))
                );
                rewardRecords.add(rewardRecord);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("rewardRecords", rewardRecords);
        request.getRequestDispatcher("RewardRecordQueryResult.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
