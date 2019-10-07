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

        <label>Proposition</label>
        <form:checkbox path="proposition" id="propositionId"/>
        <br/>

        <label>Title:</label>
        <form:input class="form-control" path="title" type="text" id="titleId"/>
        <form:errors path="title" cssClass="error">Tytuł musi zawierać przynajmniej 5 znaków</form:errors>

        <br/>

        <label>Description</label>
        <form:textarea path="description" class="form-control" id="descriptionId"/>
        <form:errors path="description"/>

        <br/>

        <label>Rating</label>
        <form:input path="rating" type="number" class="form-control" id="ratingId"/>
        <form:errors path="rating" cssClass="error">Musi być pomiędzy 1 a 10</form:errors>

        <br/>

        <label for="publisherId">Publisher:</label>
        <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" id="publisherId" class="form-control"/>
        <form:errors path="publisher"/>

        <br/>

        <label for="authorsId">Author:</label>
        <form:select path="authors" items="${authors}" itemLabel="fullName" itemValue="id" id="authorsId" class="form-control"/>
        <form:errors path="authors"/>

        <br/>

        <label>Pages: </label>
        <form:input path="pages" class="form-control" id="pagesId"/>
        <form:errors path="pages" cssClass="error">Musisz podać ilość stron</form:errors>

        <br/>

        <input type="submit" class="btn btn-primary" value="Save">

    </form:form>
</div>
</body>
</html>
