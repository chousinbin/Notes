package controller;

import model.DB;
import model.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberQuery extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String keyword = request.getParameter("keyword");

        String sql;
        if (keyword.isEmpty() || keyword.trim().isEmpty() || keyword.equals("")) {
            sql = "select * from members";
        } else {
            sql = 
            "SELECT * " + 
            "FROM members " + 
            "WHERE " + 
            "member_name LIKE '%" + keyword + "%' OR " + 
            "member_simple_name LIKE '%" + keyword + "%' OR " + 
            "member_phone LIKE '%" + keyword + "%' OR " + 
            "member_id LIKE '%" + keyword + "%'"; 
        }

        List<Member> members = new ArrayList<>();
        try {
            DB db = new DB();

            ResultSet rs = db.excuteQ(sql);

            while (rs.next()) {
                Member member = new Member(
                    rs.getInt(1),
                    rs.getString(2), 
                    rs.getString(3), 
                    rs.getString(4),
                    rs.getDate(5),
                    rs.getBigDecimal(6),
                    rs.getInt(7),
                    rs.getBigDecimal(8),
                    rs.getBigDecimal(9),
                    "1".equals(rs.getString(10))
                );
                members.add(member);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("members", members);
        request.getRequestDispatcher("MemberQueryResult.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}