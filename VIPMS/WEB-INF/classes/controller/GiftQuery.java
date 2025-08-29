package controller;

import model.DB;
import model.Gift;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GiftQuery extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String keyword = request.getParameter("keyword");

        String sql;
        boolean st = false;
        if (keyword.isEmpty() || keyword.trim().isEmpty() || keyword.equals("")) {
            sql = "select * from gifts where gift_status = '1'";
        } else {
            sql = 
            "SELECT * " + 
            "FROM gifts " + 
            "WHERE " + 
            "gift_name LIKE ? AND gift_status = '1'"; 
            st = true;
        }

        List<Gift> gifts = new ArrayList<>();
        try {
            DB db = new DB();
            ResultSet rs = null;
            if (st == true) {
                Object[] params = new Object[] {
                "%" + keyword + "%"
                };
                rs = db.excuteQ(sql, params);
            } else {
                rs = db.excuteQ(sql);
            }

            while (rs.next()) {
                Gift gift = new Gift(
                    rs.getInt(1),
                    rs.getString(2), 
                    rs.getInt(3), 
                    rs.getInt(4)
                );
                gifts.add(gift);
            }

            db.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("gifts", gifts);
        request.getRequestDispatcher("GiftQueryResult.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}