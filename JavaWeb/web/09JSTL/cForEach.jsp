<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/5
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--遍历 fori--%>
<c:forEach begin="1" step="1" end="5" var="i">

</c:forEach>

<%--遍历 数组--%>
<c:forEach items="${items}" var="item">

</c:forEach>
<%--遍历 Map--%>
<c:forEach items="${items}" var="item">

</c:forEach>

</body>
</html>
