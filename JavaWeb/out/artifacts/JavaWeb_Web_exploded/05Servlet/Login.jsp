<%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/8/19
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="http://localhost:8080/JavaWeb/HSRT01" method="get">
    U:<input type="text" name="name"/>
    <br>
    P:<input type="password" name="password"/>
    <br>
    选择你喜欢的老师：
    <input type="checkbox" name="teacher" value="hsp">韩顺平
    <input type="checkbox" name="teacher" value="ls">老韩
    <br>
    <button type="submit" value="注册">注册</button>
</form>
</body>
</html>
