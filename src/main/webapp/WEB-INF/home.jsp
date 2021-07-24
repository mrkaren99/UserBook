<%@ page import="am.itspace.userBook.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="am.itspace.userBook.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
<% User user = (User) session.getAttribute("user");
    String msg = (String) session.getAttribute("msg");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>

<% List<Book> books = (List<Book>) request.getAttribute("books");%>
Welcome <%=user.getName() %> | <a href="/logout">Logout</a>
<a href="/addBook">Add Book</a>

<table border="1">

    <tr>
        <th>Title</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    <% if (books != null && !books.isEmpty()) {
        for (Book book : books) {
    %>
    <tr>
        <td><%=book.getTitle()%>
        </td>
        <td><%=book.getPrice()%>
        </td>
        <td><a href="/singleBook?id=<%=book.getId()%>">Show more</a> | <a
                href="/updateBook?id=<%=book.getId()%>">Update</a> | <a
                href="/deleteBook?id=<%=book.getId()%>">Delete</a></td>
    </tr>
    <% }
    }%>
</table>

</body>
</html>