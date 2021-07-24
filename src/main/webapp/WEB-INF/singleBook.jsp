<%@ page import="am.itspace.userBook.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    Book book = (Book) request.getAttribute("book");%>

<a href="/home" >Go Home</a> | <a href="/logout">Logout</a>


<h1> <%=book.getTitle()%> </h1>
<img src="/getImage?picUrl=<%=book.getPicUrl()%>" width="200"/>
Author Name: <%=book.getAuthorName()%> <br>
price: <%=book.getPrice()%> <br>
Created Date: <%= sdf.format(book.getCreatedDate())%> <br>
User name: <%=book.getUser().getName()%> <br>
User surname: <%=book.getUser().getSurname()%> <br>

</body>
</html>