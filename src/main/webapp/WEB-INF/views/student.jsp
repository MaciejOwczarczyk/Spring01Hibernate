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
<div class="form-group">

</div>
<div class="container-fluid">
    <form:form method="post" modelAttribute="student">

        <label>First Name:</label>
        <form:input path="firstName" type="text" id="firstNameId"/>

        <br/>

        <label>Last Name:</label>
        <form:input path="lastName" type="text" id="lastNameId"/>

        <br/>

        <label>Gender:</label>
        <form:radiobuttons path="gender" items="${gender}" id="genderId"/>

        <br/>

        <label>Countries:</label>
        <form:select class="form-control" path="country" items="${countries}" id="countryId"/>

        <br/>

        <label>Notes:</label>
        <form:textarea path="notes" cols="5" rows="5" id="notesId" class="form-control"/>

        <br/>

        <label>Mailling List:</label>
        <form:checkbox path="mailingList"/>

        <br/>

        <label>Programming Skills:</label>
        <form:select class="form-control" path="programmingSkills" items="${skills}" multiple="true"/>

        <br/>

        <label>Hobbies</label>
        <form:checkboxes path="hobbies" items="${hobbies}"/>

        <br/>

        <input type="submit" class="btn btn-primary" value="Save">

    </form:form>
</div>

</body>
</html>
