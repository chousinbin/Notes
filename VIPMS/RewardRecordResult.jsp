<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>积分结果</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background-color: #fff;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 500px;
            width: 100%;
        }
        .form-container h1 {
            margin-bottom: 20px;
            color: #333;
        }
        .form-container label {
            display: block;
            margin: 10px 0 5px;
            text-align: left;
        }
        .form-container input[type="text"],
        .form-container input[type="date"],
        .form-container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            background-color: #fff;
            box-sizing: border-box; /* 确保宽度计算包括内边距和边框 */
        }

        .form-container select {
            background-image: url('data:image/svg+xml;utf8,<svg fill="%23333" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M7 10l5 5 5-5z"/></svg>');
            background-repeat: no-repeat;
            background-position: right 10px center;
            background-size: 16px;
            appearance: none; /* 移除默认样式 */
        }

        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #6bbf59;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .form-container input[type="submit"]:hover {
            background-color: #5da349;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <% request.setCharacterEncoding("UTF-8"); %>

        <h1>积分结果</h1>

        <form action="" method="POST">
            <label>会员卡号:</label>
            <input type="text" name="memberId" value="${member.id}" readonly>

            <label>会员姓名:</label>
            <input type="text" name="memberName" value="${member.name}" readonly>

            <label>会员手机:</label>
            <input type="text" name="memberPhone" value="${member.phone}" readonly>

            <label>会员余额:</label>
            <input type="text" name="memberBalance" value="${member.balance}" readonly>

            <label>会员积分:</label>
            <input type="text" name="memberAvailableReward" value="${member.availableReward}" readonly>

            <label>消费方式:</label>
            <input type="text" name="payType" value="<%= request.getAttribute("recordType") %>" readonly>

            <label>消费金额:</label>
            <input type="text" name="payMoney" value = "<%= request.getAttribute("payMoney") %>" readonly>

            <a href="MemberQuery.jsp"> 完成积分 </a>
            <a href="MemberQuery?keyword=${member.name}"> 重新积分 </a>

            <div class="message">
                <% if (request.getAttribute("message") != null) { %>
                    <%= request.getAttribute("message") %>
                <% } %>
            </div>
        </form>
    </div>
</body>
</html>
