<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员信息更新</title>
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
        <center>
            <a href="DrugQuery.jsp">药品查询</a>
            <a href="DrugQuery.jsp">药品管理</a>
            <a href="StockDrugQuery.jsp">药品入库</a>
            <a href="StockQuery.jsp">库存销售</a>
            <a href="dashboard.jsp">主页</a>
        </center>
        
        <h1>会员信息更新</h1>
        <form method="post" action="MemberUpdate">
            <input type="hidden" name ="memberId" value="<%= request.getParameter("memberId") %>">
            <label>会员姓名:</label>
            <input type="text" name="memberName" value="<%= request.getParameter("memberName") %>">

            <label>会员简拼:</label>
            <input type="text" name="memberSimpleName" value="<%= request.getParameter("memberSimpleName") %>">
            
            <label>会员手机:</label>
            <input type="text" name="memberPhone" value="<%= request.getParameter("memberPhone") %>">
            
            <label>会员生日:</label>
            <input type="date" name="memberBirthday" value="<%= request.getParameter("memberBirthday") %>">
            
            <label>会员余额:</label>
            <input type="text" name="memberBalance" value="<%= request.getParameter("memberBalance") %>">

            <label>积分次数:</label>
            <input type="text" name="memberRewardTimes" value="<%= request.getParameter("memberRewardTimes") %>">

            <label>累计积分:</label>
            <input type="text" name="memberTotalReward" value="<%= request.getParameter("memberTotalReward") %>">

            <label>可用积分:</label>
            <input type="text" name="memberAvailableReward" value="<%= request.getParameter("memberAvailableReward") %>">
            
            <label>账户状态:</label>
            <select name="memberStatus">
                <option value="1" <%= "true".equals(request.getParameter("memberStatus")) ? "selected" : "" %>>正常账户</option>
                <option value="0" <%= "false".equals(request.getParameter("memberStatus")) ? "selected" : "" %>>销户账户</option>
            </select>
            
            <input type="submit" value="更新信息">
        </form>
        <div class="message">
            <% if (request.getAttribute("message") != null) { %>
                <%= request.getAttribute("message") %>
                <a href="MemberQuery.jsp"> 返回上级 </a>
            <% } %>
        </div>
    </div>
</body>
</html>
