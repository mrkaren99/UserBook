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
<h1>Login</h1>
<form action="/login" method="post">
    email: <input type="text" name="email"/> <br>
    password: <input type="password" name="password"> <br>
    <input type="submit" value="login">
</form>
<h1>Register</h1>

<form action="/register" method="post">
    name: <input type="text" name="name"/> <br>
    surname: <input type="text" name="surname"/> <br>
    email: <input type="text" name="email"/> <br>
    password: <input type="password" name="password"> <br>
    re-password: <input type="password" name="re-password"> <br>
    <input type="submit" value="register">
</form>
</body>
</html>