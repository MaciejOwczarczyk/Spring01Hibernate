<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="person">
    <form:input path="login" type="text"/>
    <form:input path="password" type="text"/>
    <form:input path="email" type="email"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
