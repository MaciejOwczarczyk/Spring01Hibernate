
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
    <form:form method="post" modelAttribute="publisher">

        <label>Name: </label>
        <form:input path="name" type="text" class="form-control" id="nameId"/>
        <form:errors path="name" cssClass="error"/>
        <br/>

        <label>REGON: </label>
        <form:input path="regon" type="regon" class="form-control" id="regonId"/>
        <form:errors path="regon" cssClass="error"/>
        <br/>

        <label>NIP: </label>
        <form:input path="nip" type="nip" class="form-control" id="nipId"/>
        <form:errors path="nip" cssClass="error"/>
        <br/>

        <input type="submit" class="btn btn-primary" value="Save">

    </form:form>
</div>
</body>
</html>
