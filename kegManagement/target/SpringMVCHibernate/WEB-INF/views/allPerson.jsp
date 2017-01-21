<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 1/18/2017
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All registered Person</title>
</head>
<body>
<table border="1">
    <h1>List of registered Employee</h1>
    <c:forEach items="${personList}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.country}</td>
            <div>
           <td><a href="<c:url value='/edit-${person.id}-person'/>">Edit </a></td>
            </div>
           <td><a href="<c:url value='/delete-${person.id}-person'/>"/>delete </td>
        </tr>
    </c:forEach>
</table>

</br>
<div>
    <a href="<c:url value='/newPerson'/>">Add New User</a>
</div>
</body>
</html>
