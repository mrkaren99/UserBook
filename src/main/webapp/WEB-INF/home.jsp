<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="am.itspace.userBook.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="am.itspace.userBook.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <script data-require="jquery@*" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <script data-require="bootstrap@*" data-semver="3.1.1" src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link data-require="bootstrap-css@3.1.1" data-semver="3.1.1" rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" />

</head>
<body>
<span><c:out value="${sessionScope.getOrDefault('msg','')}"/></span>
<c:if test="${sessionScope.get('msg') != null}">
    <c:remove var="msg" scope="session"/>
</c:if>

Welcome <c:out value="${sessionScope.get('user').name}" /> | <a href="/logout">Logout</a>


<div id="books"></div>


<script>





    $(document).ready(function () {




        getBooks();
        // setInterval(getBooks, 3000);


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