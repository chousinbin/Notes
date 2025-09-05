<%@ page import="JSP.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: sinpin
  Date: 2025/9/5
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Book book = new Book();
    book.setName("活着");
    book.setAuthor(new String[]{"余华", "余hua"});
    ArrayList<String> reader = new ArrayList<>();
    reader.add("zxb");
    reader.add("xb");
    book.setReader(reader);

    HashMap<String, String> comments = new HashMap<>();
    comments.put("1", "good");
    comments.put("2", "nice");
    book.setComment(comments);

    request.setAttribute("book", book);
%>
book对象: ${book}
<br>
book_name = ${book.name}
<br>
book_authors = ${book.author}
<br>
book_author = ${book.author[0]}
<br>
book_readers = ${book.reader}
<br>
book_reader = ${book.reader.get(1)}
<br>
book_comments = ${book.comment}
<br>
book_comment = ${book.comment.get("1")}
</body>
</html>
