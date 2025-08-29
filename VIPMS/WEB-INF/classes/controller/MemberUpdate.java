package controller;

import model.DB;
import model.Member;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberUpdate extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String message = "更新成功"; // 默认更新成功

        Member member = new Member();
        try {
            // 获取前端传递的参数，并填充 Member 对象
            member.setId(parseInteger(request.getParameter("memberId")));
            member.setName(request.getParameter("memberName"));
            member.setSimpleName(request.getParameter("memberSimpleName"));
            member.setPhone(request.getParameter("memberPhone"));

            // 解析生日
            String birthdayStr = request.getParameter("memberBirthday");
            Date birthday = (birthdayStr != null && !birthdayStr.isEmpty()) 
                            ? new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr) 
                            : null;
            member.setBirthday(birthday);

            member.setBalance(parseBigDecimal(request.getParameter("memberBalance")));
            member.setRewardTimes(parseInteger(request.getParameter("memberRewardTimes")));
            member.setTotalReward(parseBigDecimal(request.getParameter("memberTotalReward")));
            member.setAvailableReward(parseBigDecimal(request.getParameter("memberAvailableReward")));
            member.setStatus("1".equals(request.getParameter("memberStatus")));

            // 更新数据库
            DB db = new DB();
            String sql = "UPDATE members SET member_name = ?, member_simple_name = ?, member_phone = ?, "
                    + "member_birthday = ?, member_balance = ?, member_reward_times = ?, "
                    + "member_total_reward = ?, member_available_reward = ?, member_status = ? "
                    + "WHERE member_id = ?";

            Object[] params = {
                    member.getName(),
                    member.getSimpleName(),
                    member.getPhone(),
                    new java.sql.Date(member.getBirthday().getTime()), // java.util.Date -> java.sql.Date
                    member.getBalance(),
                    member.getRewardTimes(),
                    member.getTotalReward(),
                    member.getAvailableReward(),
                    member.isStatus() ? "1" : "0", // 转换布尔值为数据库存储格式
                    member.getId()
            };

            int rowsAffected = db.excuteU(sql, params);
            if (rowsAffected == 0) {
                message = "更新失败，会员不存在！";
            }
        } catch (ParseException e) {
            message = "日期格式错误：" + e.getMessage();
        } catch (NumberFormatException e) {
            message = "数字格式错误：" + e.getMessage();
        } catch (Exception e) {
            message = "数据库错误：" + e.getMessage();
        }

        // 统一页面转发
        request.setAttribute("message", message);
        request.setAttribute("memberStatus", String.valueOf(member.isStatus()));
        request.getRequestDispatcher("MemberUpdate.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    // 解析整数，避免 NumberFormatException
    private static int parseInteger(String value) {
        try {
            return (value != null && !value.isEmpty()) ? Integer.parseInt(value) : 0;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    // 解析 BigDecimal，避免 NumberFormatException
    private static BigDecimal parseBigDecimal(String value) {
        try {
            return (value != null && !value.isEmpty()) ? new BigDecimal(value) : BigDecimal.ZERO;
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        }
    }
}
