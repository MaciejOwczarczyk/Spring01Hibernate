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
            <th>Title</th>
            <th>Rating</th>
            <th>Publisher</th>
            <th>Description</th>
            <%--<th>Authors</th>--%>
            <th>Action</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.rating}</td>
                <td>${book.publisher.name}</td>
                <td>${book.description}</td>
                <%--<td>${book.authors}</td>--%>
                <td>
                    <a href="edit/${book.id}" class="btn btn-primary">Edit</a>
                    <a href="confirmDelete/${book.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
