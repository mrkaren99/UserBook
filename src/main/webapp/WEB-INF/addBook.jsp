<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
<% String msg = (String) session.getAttribute("msg");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>
<h1>AddBook</h1> | <a href="/logout">Logout</a>


<form action="/addBook" method="post" enctype="multipart/form-data">
    title: <input type="text" name="title"/> <br>
    authorName: <input type="text" name="authorName"/> <br>
    price: <input type="number" name="price"/> <br>
    picture: <input type="file" name="picture"> <br>
    <input type="submit" value="add book">
</form>
</body>
</html>