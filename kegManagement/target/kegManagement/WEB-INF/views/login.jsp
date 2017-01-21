<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 1/18/2017
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h1> ${welcome} </h1>
<form:form method="post" modelattribute="person">
    <h1>Login Form</h1>
    <input type="text" class="login-input" placeholder="UserName" />
    <input type="text" class="login-input" placeholder="Password" />
    <input type="submit"  class="login-submit" value="log in">
    <p> <a href="index.html" class="login-help"> forget password</a> </p>
</form:form>
</body>
</html>
