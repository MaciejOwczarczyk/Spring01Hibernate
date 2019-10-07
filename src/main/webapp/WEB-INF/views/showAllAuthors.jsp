<%--
  Created by IntelliJ IDEA.
  User: MaciejO
  Date: 2019-10-01
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <table class="table">
        <tr>
            <th >
                <a href="/author/add" class="btn btn-success">Add new author</a>
            </th>
        </tr>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of birth</th>
            <th>PESEL</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${authors}" var="author">
            <tr>
                <td>${author.firstName}</td>
                <td>${author.lastName}</td>
                <td>${author.yearOfBirth}</td>
                <td>${author.pesel}</td>
                <td>${author.email}</td>
                <td>
                    <a href="edit/${author.id}" class="btn btn-primary">Edit</a>
                    <a href="confirmDelete/${author.id}" class="btn btn-danger">Delete</a>
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
