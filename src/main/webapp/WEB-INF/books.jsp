<%@ page import="am.itspace.userBook.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Book> books = (List<Book>) request.getAttribute("books");%>
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