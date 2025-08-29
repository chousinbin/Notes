<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员信息列表</title>
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
        <a href="MemberQuery.jsp">会员查询</a>---
        <a href="MemberAdd.jsp">会员添加</a>---
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
                <th>会员生日</th>
                <th>账户储值</th>
                <th>积分次数</th>
                <th>累计积分</th>
                <th>可用积分</th>
                <th>账户状态</th>
                <th>操作</th>
                <th>积分</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="member" items="${members}">
                <tr>
                    <td>${member.id}</td>
                    <td>${member.name}</td>
                    <td>${member.simpleName}</td>
                    <td>${member.phone}</td>
                    <td>${member.birthday}</td>
                    <td>${member.balance}</td>
                    <td>${member.rewardTimes}</td>
                    <td>${member.totalReward}</td>
                    <td>${member.availableReward}</td>
                    <td>${member.status}</td>
                    <td>
                        <form action="MemberUpdate.jsp" method="POST" style="display:inline;">
                            <input type="hidden" name="memberId" value="${member.id}">
                            <input type="hidden" name="memberName" value="${member.name}">
                            <input type="hidden" name="memberSimpleName" value="${member.simpleName}">
                            <input type="hidden" name="memberPhone" value="${member.phone}">
                            <input type="hidden" name="memberBirthday" value="${member.birthday}">
                            <input type="hidden" name="memberBalance" value="${member.balance}">
                            <input type="hidden" name="memberRewardTimes" value="${member.rewardTimes}">
                            <input type="hidden" name="memberAvailableReward" value="${member.availableReward}">
                            <input type="hidden" name="memberTotalReward" value="${member.totalReward}">
                            <input type="hidden" name="memberStatus" value="${member.status}">
                            <button type="submit">修改</button>
                        </form>
                        <form action="MemberDelete" method="POST" style="display:inline;">
                            <input type="hidden" name="memberId" value="${member.id}">
                            <button type="submit" class="delete">删除</button>
                        </form>
                    </td>
                    <td>
                        <form action="RewardRecord.jsp" method="POST" style="display:inline;">
                            <input type="hidden" name="memberId" value="${member.id}">
                            <input type="hidden" name="memberName" value="${member.name}">
                            <input type="hidden" name="memberPhone" value="${member.phone}">
                            <input type="hidden" name="memberBalance" value="${member.balance}">
                            <input type="hidden" name="memberAvailableReward" value="${member.availableReward}">
                            <button type="submit" class="record">积分</button>
                        </form>
                    </td>
                
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
