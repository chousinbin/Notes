<%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/5
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext 对象的使用</title>
</head>
<body>
<h1>pageContext 对象的使用</h1>
<%--
//通过 request 对象来获取和 HTTP 协议相关的数据
request.getScheme() 它可以获取请求的协议
request.getServerName() 获取请求的服务器 ip 或域名
request.getServerPort() 获取请求的服务器端口号
getContextPath() 获取当前工程路径
request.getMethod() 获取请求的方式（GET 或 POST）
request.getRemoteHost() 获取客户端的 ip 地址
session.getId() 获取会话的唯一标识韩顺平 Java 工程师
--%>
<hr/>
协议： ${ pageContext.request.scheme }<br>
服务器 ip：${ pageContext.request.serverName }<br>
服务器端口：${ pageContext.request.serverPort }<br>
工程路径：${ pageContext.request.contextPath }<br>
请求方法：${ pageContext.request.method }<br>
客户端 ip 地址：${ pageContext.request.remoteHost }<br>
会话 id ：${ pageContext.session.id }<br>
<h1>使用 jsp 表达式脚本获取如上信息</h1>
ip 地址: <%=request.getRemoteHost() %> <br>
<h1>使用 el 表达式形式获取信息</h1>
<%
    pageContext.setAttribute("req", request);
%>
ip 地址: ${req.remoteHost} <br>
获取请求方法: ${req.method} <br>
</body>
</html>
