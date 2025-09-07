<%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/7
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/LoginCheck">
  u: <input type="text" name="username">
  <br>
  P: <input TYPE="text" name="password">
  <br>
  <input type="submit" value="登陆">
</form>
</body>
</html>
