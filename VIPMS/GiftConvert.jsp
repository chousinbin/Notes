<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>礼品兑换</title>
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
            <a href="GiftQuery?keyword=">返回上级</a>
        </center>
        
        <h1>礼品兑换</h1>
        <form method="post" action="GiftConvert">
            <input type="hidden" name ="giftId" value="<%= request.getParameter("giftId") %>">
            <label>礼物名称:</label>
            <input type="text" name="giftName" value="<%= request.getParameter("giftName") %>" readonly>
            
            <label>礼物所需积分:</label>
            <input type="text" name="giftValue" value="<%= request.getParameter("giftValue") %>" readonly>
            
            <label>礼物库存:</label>
            <input type="text" name="giftStock" value="<%= request.getParameter("giftStock") %>" readonly>

            <label>兑换数量:</label>
            <input type="text" name="convertNumber" value="">

            <label>会员卡号:</label>
            <input type="text" name="memberId" value="">
            
            <input type="submit" value="兑换礼品">
        </form>
        <div class="message">
            <% if (request.getAttribute("message") != null) { %>
                <%= request.getAttribute("message") %>
                <a href="dashboard.jsp"> 返回上级 </a>
            <% } %>
        </div>
    </div>
</body>
</html>
