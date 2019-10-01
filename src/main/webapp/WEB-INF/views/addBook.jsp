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
    <form:form method="post" modelAttribute="book">

        <label>Title:</label>
        <form:input class="form-control" path="title" type="text" id="titleId"/>

        <br/>

        <label>Rating</label>
        <form:input path="rating" type="number" class="form-control" id="ratingId"/>

        <br/>

        <label>Description</label>
        <form:textarea path="description" class="form-control" id="descriptionId"/>

        <br/>

        <label for="publisherId">Publisher:</label>
        <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" id="publisherId" class="form-control"/>

        <br/>

        <label for="authorsId">Author:</label>
        <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id" id="authorsId" class="form-control"/>

        <br/>

        <input type="submit" class="btn btn-primary" value="Save">

    </form:form>
</div>

</body>
</html>
