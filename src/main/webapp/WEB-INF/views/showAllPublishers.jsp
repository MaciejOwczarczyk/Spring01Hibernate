<%--
  Created by IntelliJ IDEA.
  User: maciejowczarczyk
  Date: 01/10/2019
  Time: 18:34
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
    <form:form method="post" modelAttribute="pusblishers">
        <table class="table">
            <tr>
                <th >
                    <a href="/publisher/add" class="btn btn-success">Add new publisher</a>
                </th>
            </tr>
            <tr>
                <th>Name</th>
                <th>Nip</th>
                <th>REGON</th>
                <th>Action</th>
            </tr>

            <c:forEach items="${pusblishers}" var="publisher">
                <tr>
                <td class="title">${publisher.name}</td>
                <td>${publisher.nip}</td>
                <td>${publisher.regon}</td>
                <td>
                    <a href="edit/${publisher.id}" class="btn btn-primary">Edit</a>
                    <a href="confirmDelete/${publisher.id}" class="btn btn-danger">Delete</a>
                </td>
                </tr>
            </c:forEach>
            <tr>
                <th>
                    <a href="/" class="btn btn-warning">Back</a>
                </th>
            </tr>
        </table>

    </form:form>
</div>
</body>
</html>
