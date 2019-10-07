<%--
  Created by IntelliJ IDEA.
  User: maciejowczarczyk
  Date: 05/10/2019
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="error" items="${errors}">
    <div>${error.path} : ${error.message}</div>
</c:forEach>
</body>
</html>
