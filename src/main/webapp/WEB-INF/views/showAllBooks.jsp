<%--
  Created by IntelliJ IDEA.
  User: MaciejO
  Date: 2019-10-01
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <table class="table">
        <tr>
            <th >
                <a href="/book/add" class="btn btn-success">Add new book</a>
            </th>
        </tr>
        <tr>
            <th>Title</th>
            <th>Rating</th>
            <th>Description</th>
            <th>Propostion</th>
            <th>Publisher</th>
            <th>Authors</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.rating}</td>
                <td>${book.description}</td>
                <td>${book.proposition}</td>
                <td>${book.publisher.name}</td>
                <td>
                    <c:forEach items="${book.authors}" var="author">
                        ${author.fullName}</br>
                    </c:forEach>
                </td>
                <td>
                    <a href="edit/${book.id}" class="btn btn-primary">Edit</a>
                    <a href="confirmDelete/${book.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <th>
                <a href="/" class="btn btn-warning">Back</a>
            </th>
        </tr>
    </table>
</div>
</body>
</html>
