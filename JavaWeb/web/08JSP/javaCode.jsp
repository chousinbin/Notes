<%@ page import="java.util.ArrayList" %>
<%@ page import="JSP.Monster" %><%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/3
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>演示代码脚本</title>
</head>
<body>
<%
    ArrayList<Monster> monsters = new ArrayList<>();
    monsters.add(new Monster(1, "牛魔王", "芭蕉扇"));
    monsters.add(new Monster(2, "蜘蛛精", "土著死"));
%>
<table style="border: 1px solid black;border-collapse: collapse;text-align: center;">

    <tr>
        <th>ID</th>
        <th>名称</th>
        <th>技能</th>
    </tr>
    <%
        for (int i = 0; i < monsters.size(); i++) {
    %>
    <tr>
        <td><%=monsters.get(i).getId()%></td>
        <td><%=monsters.get(i).getName()%></td>
        <td><%=monsters.get(i).getSkill()%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
