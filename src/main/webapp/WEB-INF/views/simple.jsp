
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="student" method="post">
    <form:input path="firstName"/>
    <form:input path="password"/>
    <form:input path="notes" rows="3" cols="20"/>
    <form:checkbox path="receiveMessages"/>
    <form:checkboxes path="skills" items="${skills}"/>
    <input type="submit" value="save">
</form:form>

</body>
</html>
