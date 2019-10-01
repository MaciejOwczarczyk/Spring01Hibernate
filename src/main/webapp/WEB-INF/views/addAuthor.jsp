<%--
  Created by IntelliJ IDEA.
  User: MaciejO
  Date: 2019-10-01
  Time: 14:32
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

    <form:form method="post" modelAttribute="author">

        <label>First Name:</label>
        <form:input path="firstName" class="form-control" type="text" id="firstNameId"/>

        <br/>

        <label>Last Name: </label>
        <form:input path="lastName" class="form-control" type="text" id="lastNameId"/>

        <br/>

        <input type="submit" value="Save" class="btn btn-primary">

    </form:form>
</div>

</body>
</html>
