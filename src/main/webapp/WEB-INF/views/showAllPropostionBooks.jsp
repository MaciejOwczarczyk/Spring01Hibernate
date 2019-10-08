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
                <a href="/proposition/add" class="btn btn-success">Add new book/proposition</a>
            </th>
        </tr>
        <tr>
            <th>Title</th>
            <th>Description</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.description}</td>
                <td>
                    <a href="/proposition/edit/${book.id}" class="btn btn-primary">Edit</a>
                    <a href="/proposition/confirmDelete/${book.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <th>
                <a href="/book/showAll" class="btn btn-warning">Back</a>
            </th>
        </tr>
    </table>
</div>
</body>
</html>
