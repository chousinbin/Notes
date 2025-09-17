<%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/17
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件下载</title>
    <base href="<%=request.getContextPath()+"/"%>>">
</head>
<body>
<h1>文件下载</h1>
<a href="fileDownload?name=图1.jpeg">点击下载长城图片</a><br/><br/>
<a href="fileDownload?name=韩顺平零基础Java笔记.pdf">点击下载 韩顺平零基础Java笔记.pdf</a><br/><br/>
<a href="fileDownload?name=高山流水.mp3">点击下载 高山流水.mp3</a><br/><br/>
</body>
</html>
