<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>礼品信息列表</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
        }
        form {
            width: 50%;
            margin: 20px auto;
            text-align: center;
        }
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        table th, table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        table th {
            background-color: #f9f9f9;
        }
        button {
            padding: 5px 10px;
            border: none;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            border-radius: 3px;
        }
        button.delete {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <center>
        <a href="GiftQuery.jsp">礼品查询</a> ---
        <a href="GiftAdd.jsp">礼品添加</a> ---
        <a href="dashboard.jsp">系统主页</a>
    </center>
    <!-- <p>drugList大小: ${drugList.size()}</p> -->
    <table>
        <thead>
            <tr>
                <th>礼品ID</th>
                <th>礼品名称</th>
                <th>礼品数量</th>
                <th>礼品价值</th>
                <th>操作</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="gift" items="${gifts}">
                <tr>
                    <td>${gift.id}</td>
                    <td>${gift.name}</td>
                    <td>${gift.stock}</td>
                    <td>${gift.value}</td>
                    
                    <td>
                        <form action="GiftDelete" method="POST" style="display:inline;">
                            <input type="hidden" name="giftId" value="${gift.id}">
                            <button type="submit" class="delete">删除</button>
                        </form>
                        <form action="GiftConvert.jsp" method="GET" style="display:inline;">
                            <input type="hidden" name="giftId" value="${gift.id}">
                            <input type="hidden" name="giftName" value="${gift.name}">
                            <input type="hidden" name="giftStock" value="${gift.stock}">
                            <input type="hidden" name="giftValue" value="${gift.value}">
                            <button type="submit" >兑换</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
