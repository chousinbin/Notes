<%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/4
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("name", "zxb");
%>
<%=request.getAttribute("name")%>
${name}
<%=request.getAttribute("name") == null ? "" : request.getAttribute("name")%>
</body>
</html>
