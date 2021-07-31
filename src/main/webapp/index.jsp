<%@ page import="am.itspace.userBook.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <script src="js/jquery-3.6.0.js"></script>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
        response.sendRedirect("/home");
    }

    String msg = (String) session.getAttribute("msg");%>
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

<div>
    <div id="box" style="width: 200px; height: 200px; border: 1px solid black; background-color: blue"></div>
    <button onclick="changeColor()">Change to Red</button>
</div>
</body>

<script>

    $(document).ready(function (){
        // alert("hello")
    })

    function changeColor() {
        $('#box').toggle();
    }


</script>
</html>