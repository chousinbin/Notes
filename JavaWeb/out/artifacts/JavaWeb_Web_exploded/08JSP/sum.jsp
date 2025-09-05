<%@ page import="org.apache.jasper.runtime.HttpJspBase" %>
<%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/3
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // Java 代码块
    int i = 10;
    int j = 20;
    int res = i + j;
    out.println(i + " + " + j + " = " + res);
    // HttpJspBase
%>
<%-- JSP注释 --%>
<!-- HTML注释-->
</body>
</html>
