package controller;

import model.DB;
import model.Member;
import model.Gift;
import model.ConvertRecord;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.text.SimpleDateFormat;


public class GiftConvertRecordQuery extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String keyword = request.getParameter("keyword");

        String sql;
        boolean st = false;
        if (keyword == null || keyword.trim().isEmpty()) {
            sql = "SELECT " + 
            "m.member_id, m.member_name, m.member_simple_name, m.member_phone, g.gift_name, g.gift_value, cr.gift_quantity, cr.reward_used, cr.gift_record_date " + 
            "FROM convert_records cr " + 
            "INNER JOIN members m ON cr.member_id = m.member_id " + 
            "INNER JOIN gifts g ON cr.gift_id = g.gift_id " + 
            "ORDER BY cr.gift_record_date DESC";
        } else {
            sql = "SELECT " + 
            "m.member_id, m.member_name, m.member_simple_name, m.member_phone, g.gift_name, g.gift_value, cr.gift_quantity, cr.reward_used, cr.gift_record_date " + 
            "FROM convert_records cr " + 
            "INNER JOIN members m ON cr.member_id = m.member_id " + 
            "INNER JOIN gifts g ON cr.gift_id = g.gift_id " + 
            "WHERE m.member_name LIKE ? OR m.member_simple_name LIKE ? OR m.member_phone LIKE ? OR g.gift_name LIKE ? " + 
            "ORDER BY cr.gift_record_date DESC";
            st = true;
        }

        List<ConvertRecord> convertRecords = new ArrayList<>();
        try {
            DB db = new DB();

            Object[] params = new Object[] {
                "%" + keyword + "%",
                "%" + keyword + "%",
                "%" + keyword + "%",
                "%" + keyword + "%"
            };

            ResultSet rs = null;
            if (st == true) {
                rs = db.excuteQ(sql, params);
            } else {
                rs = db.excuteQ(sql);
            }

            while (rs.next()) {
                ConvertRecord convertRecord = new ConvertRecord(
                    rs.getInt(1),
                    rs.getString(2), 
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getBigDecimal(8),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(rs.getTimestamp(9).getTime()))
                );
                convertRecords.add(convertRecord);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("convertRecords", convertRecords);
        request.getRequestDispatcher("GiftConvertRecordQueryResult.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
