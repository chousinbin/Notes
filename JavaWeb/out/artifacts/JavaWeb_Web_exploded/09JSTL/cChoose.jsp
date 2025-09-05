<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/5
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set scope="request" var="scope" value="90"></c:set>
<c:choose>
    <c:when test="${scope > 80}">
        <h1>优秀</h1>
    </c:when>
    <c:when test="${scope > 60}">
        <h1>及格</h1>
    </c:when>
    <c:otherwise>
        <h1>不及格</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
