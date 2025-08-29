package controller;

import model.DB;
import model.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigDecimal;
import java.sql.*;

public class RewardRecord extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String payType = request.getParameter("payType");
        String payMoneyStr = request.getParameter("payMoney");
        BigDecimal payMoney = new BigDecimal(payMoneyStr);

        // 获取会员信息
        Member member = new Member();
        member.setId(Integer.parseInt(request.getParameter("memberId")));
        member.setName(request.getParameter("memberName"));
        member.setPhone(request.getParameter("memberPhone"));
        member.setBalance(new BigDecimal(request.getParameter("memberBalance")));
        member.setAvailableReward(new BigDecimal(request.getParameter("memberAvailableReward")));

        DB db = new DB();
        String recordType;
        String message = "积分记录成功"; // 默认成功信息
        boolean success = true;

        if ("0".equals(payType)) {
            recordType = "现金";
        } else {
            recordType = "余额";
            if (payMoney.compareTo(member.getBalance()) > 0) {
                message = "余额不足，请检查";
                success = false;
            } else {
                // 扣除余额
                String sql = "UPDATE members SET member_balance = member_balance - ? WHERE member_id = ?";
                db.excuteU(sql, new Object[]{payMoney, member.getId()});
                // 更新 bean 余额
                member.setBalance(member.getBalance().subtract(payMoney));
            }
        }

        if (success) {
            // 更新积分
            String sql1 = "UPDATE members SET member_reward_times = member_reward_times + 1, " +
                          "member_total_reward = member_total_reward + ?, " +
                          "member_available_reward = member_available_reward + ? " +
                          "WHERE member_id = ?";
            db.excuteU(sql1, new Object[]{payMoney, payMoney, member.getId()});

            // 插入积分记录
            String sql2 = "INSERT INTO reward_records (member_id, record_amount, record_type) VALUES (?, ?, ?)";
            db.excuteU(sql2, new Object[]{member.getId(), payMoney, recordType});

            // 更新 bean 积分
            member.setAvailableReward(member.getAvailableReward().add(payMoney));
        }

        // 统一页面转发
        request.setAttribute("member", member);
        request.setAttribute("recordType", recordType);
        request.setAttribute("payMoney", payMoney);
        request.setAttribute("message", message);
        request.getRequestDispatcher("RewardRecordResult.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
