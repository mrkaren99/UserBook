<%@ page import="am.itspace.userBook.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="am.itspace.userBook.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <script src="js/jquery-3.6.0.js"></script>

</head>
<body>
<% User user = (User) session.getAttribute("user");
    String msg = (String) session.getAttribute("msg");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>

Welcome <%=user.getName() %> | <a href="/logout">Logout</a>
<a href="/addBook">Add Book</a>

<div id="books"></div>

<script>
    $(document).ready(function () {
        getBooks();
        setInterval(getBooks, 3000);
    })

    function getBooks() {
        $.ajax({
            url: 'http://localhost:8080/books',
            method: 'GET'
        }).done(function (data) {
            $("#books").html(data)
        })
    }
</script>
</body>
</html>