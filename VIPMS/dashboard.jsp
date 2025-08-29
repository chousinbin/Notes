<%@ page import="model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>主页</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
        }
        header {
            background-color: #3c503e;
            color: white;
            padding: 15px 20px;
            text-align: center;
            font-size: 24px;
        }
        .container {
            max-width: 600px;
            margin: 40px auto;
            background: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
        }
        ul {
            list-style-type: none;
            padding: 0;
            margin: 20px 0;
        }
        ul li {
            margin: 12px 0;
        }
        ul li a {
            display: block;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 18px;
            transition: background-color 0.3s;
        }
        ul li a:hover {
            background-color: #45a049;
        }
        .message {
            font-size: 18px;
            color: #d9534f;
        }
        .login-link {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }
        .login-link:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <% 
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String username = user.getUsername();
            String role = user.getRole();
    %>
    <header>欢迎你，<%= username %>（角色：<%= role %>）</header>
    <div class="container">
        <ul>
            <li><a href="MemberQuery.jsp">会员信息管理</a></li>
            <li><a href="RewardRecordQuery.jsp">积分记录查询</a></li>
            <li><a href="GiftQuery.jsp">积分兑换礼品</a></li>
            <li><a href="GiftConvertRecordQuery.jsp">礼品兑换查询</a></li>
            <li><a href="index.jsp">退出登录</a></li>
        </ul>
    </div>
    <% 
        } else { 
    %>
    <div class="container">
        <p class="message">Session 已过期，请重新登录。</p>
        <a href="index.jsp" class="login-link">重新登录</a>
    </div>
    <% 
        }
    %>
</body>
</html>
