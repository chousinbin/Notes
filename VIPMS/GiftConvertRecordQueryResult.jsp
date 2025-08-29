<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>礼品兑换记录信息</title>
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
        button.record {
            background-color: #0069bf;
        }
    </style>
</head>
<body>
    <% request.setCharacterEncoding("UTF-8"); %>
    <center>
        <a href="GiftConvertRecordQuery?keyword=">重新搜索</a>
        <a href="dashboard.jsp">系统主页</a>

    </center>
    <!-- <p>drugList大小: ${drugList.size()}</p> -->
    <table>
        <thead>
            <tr>
                <th>会员卡号</th>
                <th>会员姓名</th>
                <th>会员简拼</th>
                <th>会员手机</th>
                <th>礼物名称</th>
                <th>礼物价值</th>
                <th>兑换个数</th>
                <th>消耗积分</th>
                <th>兑换时间</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="convertRecord" items="${convertRecords}">
                <tr>
                    <td>${convertRecord.memberId}</td>
                    <td>${convertRecord.memberName}</td>
                    <td>${convertRecord.memberSimpleName}</td>
                    <td>${convertRecord.memberPhone}</td>
                    <td>${convertRecord.giftName}</td>
                    <td>${convertRecord.giftValue}</td>
                    <td>${convertRecord.convertNumber}</td>
                    <td>${convertRecord.rewardUsed}</td>
                    <td>${convertRecord.convertDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
