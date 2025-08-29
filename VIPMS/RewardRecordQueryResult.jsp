<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>积分记录信息</title>
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
        <a href="RewardRecordQuery.jsp">重新搜索</a>
        <a href="dashboard.jsp">系统主页</a>

    </center>
    <!-- <p>drugList大小: ${drugList.size()}</p> -->
    <table>
        <thead>
            <tr>
                <th>积分记录ID</th>
                <th>会员卡号</th>
                <th>会员姓名</th>
                <th>会员手机</th>
                <th>积分类型</th>
                <th>积分数量</th>
                <th>积分时间</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="rewardRecord" items="${rewardRecords}">
                <tr>
                    <td>${rewardRecord.recordId}</td>
                    <td>${rewardRecord.memberId}</td>
                    <td>${rewardRecord.memberName}</td>
                    <td>${rewardRecord.memberPhone}</td>
                    <td>${rewardRecord.recordType}</td>
                    <td>${rewardRecord.recordAmount}</td>
                    <td>${rewardRecord.recordDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
