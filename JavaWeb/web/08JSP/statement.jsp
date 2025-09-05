<%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/3
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>声明脚本</title>
</head>
<body>
<%!
    // 声明 JSP 需要使用的属性、方法、静态代码块、内部类
    private String name = "zxb";
    private static String company;

    public String getName() {
        return name;
    }

    static {
        company = "ByteDance";
    }
%>
</body>
</html>
