package controller;

import model.DB;
import model.Member;
import model.Gift;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigDecimal;
import java.sql.*;

public class GiftConvert extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        // 获取前端信息
        int giftId = Integer.parseInt(request.getParameter("giftId"));
        String giftName = request.getParameter("giftName");
        int convertNumber = Integer.parseInt(request.getParameter("convertNumber"));
        String memberId = request.getParameter("memberId");
        int giftStock = Integer.parseInt(request.getParameter("giftStock"));
        int giftValue = Integer.parseInt(request.getParameter("giftValue"));
        
        String message = "兑换成功"; // 默认成功信息
        boolean st = true;
        
        // 判断库存是否满足
        if (giftStock < convertNumber) {
            message = "库存不足，无法兑换";
            st = false;
        }
        // 判断会员是否存在
        DB db = new DB();
        String sql = "select member_available_reward from members where member_id = ?";
        Object[] params = new Object[] {memberId};
        ResultSet rs = db.excuteQ(sql, params);
        int oldReward = 0;

        try {
            
            if (rs.next()) {
                oldReward = rs.getInt(1);
            } else {
                message = "会员不存在";
                st = false;
            }

            // 判断会员积分是否足够
            int awards = rs.getInt(1);
            if (awards < convertNumber * giftValue) {
                message = "积分不足";
                st = false;
            }

            // 成功兑换
            if (st) {
                // 更新积分
                sql = "UPDATE members SET member_available_reward = member_available_reward - ? WHERE member_id = ?";
                db.excuteU(sql, new Object[]{convertNumber * giftValue, memberId});

                // 更新礼品库存
                sql = "UPDATE gifts SET gift_stock = gift_stock - ? WHERE gift_id = ?";
                db.excuteU(sql, new Object[]{convertNumber, giftId});

                // 添加兑换记录
                sql = "INSERT INTO convert_records (member_id, gift_id, gift_quantity, reward_used)" + 
                "values(?, ?, ?, ?)";
                db.excuteU(sql, new Object[]{memberId, giftId, convertNumber, convertNumber * giftValue});
            }

            db.close();
        } catch(Exception e) {
             e.printStackTrace();
        }
        

        // 统一页面转发
        Gift gift = new Gift(giftId, giftName, st ? giftStock - convertNumber : giftStock, giftValue);
        request.setAttribute("gift", gift);
        request.setAttribute("convertNumber", convertNumber);
        request.setAttribute("memberId", memberId);
        request.setAttribute("avaliableReward", st ? oldReward - convertNumber * giftValue : oldReward);
        request.setAttribute("message", message);
        request.getRequestDispatcher("GiftConvertResult.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        doGet(request, response);
    }
}
