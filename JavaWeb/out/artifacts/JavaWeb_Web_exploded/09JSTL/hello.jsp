<%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/5
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (10 > 2) {
        out.print("<h1> 10 > 2 成立</h1>");
    }
%>

<c:if test="${10 > 2}">
    <h1> 10 > 2 成立</h1>
</c:if>
</body>
</html>
