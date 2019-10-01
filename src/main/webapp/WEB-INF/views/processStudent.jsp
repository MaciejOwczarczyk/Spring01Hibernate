
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
    <label>First Name:</label>
    ${student.firstName}

    <br/>

    <label>Last Name:</label>
    ${student.lastName}

    <br/>

    <label>Gender:</label>
    ${student.gender}

    <br/>

    <label>Country</label>
    ${student.country}

    <br/>

    <label>Notes</label>
    ${student.notes}

    <br/>

    <label>Mailing</label>
    ${student.mailingList}

    <br/>

    <label>Programming Skills</label>
    ${student.programmingSkills}

    <br/>

    <label>Hobbies: </label>
    <c:out value="${student.hobbies}"/>

    <br/>

</div>
</body>
</html>
