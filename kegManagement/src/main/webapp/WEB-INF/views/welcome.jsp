<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 12/2/2016
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Greeting : ${greeting}</title>
</head>
<body>
<h1> Welcome to Spring hell Number one </h1>
<button type="button" onclick="listPerson()">Persons</button>
<button type="button" onclick="addPerson()">Add person</button>
<button type="button" onclick="addCall()">Add Call</button>
<p id="personList"> List of person</p>

<p id="newPerson">  ${fn:toUpperCase("List of Customers ")} </p>
<p id="list">Call made by customer</p>
<p>
    you can <i> <a href="/person/add"> Add New Person </a></i>
</p>
<p>
    you can <i> <a href="/persons"> show list of person </a></i>
</p>
<p>
    you can <i> <a href="//Students/addStudent"> Add student </a></i>
</p>


<script>
function listPerson() {

    document.getElementById("personList").innerHTML("Abebe")

}

function addPerson() {

    document.getElementById("newPerson").innerHTML("Daniel ")

}

function addCall() {

    document.getElementById("list").innerHTML("on DEC")

}
</script>
<% int day=3; %>
<p>this is example of control flow in JSP</p>
<% if (day==1 | day==7 ) { %>
<p>This is weekend</p>
<%} else %>
<% { %>
<p>This is Weekday</p>
<%}%>
<center>
<h2> This is Include  Action Example</h2>
<jsp:include page="date.jsp" flush="true"/>
</center>



<table width="100%" border="1" bgcolor="#f0f8ff">
<tr width="100%" align="center"> <th>Customer List  </th> </tr>
    <tr>
    <th>First Name</th> <th>Last Name</th> <th>Email Address</th>
</tr>
</table>

<form action="Students.jsp" method="post">
    First Name: <input type="text" name="First_name"> <br/>
    Last Name : <input type="text" name="Last_name"> <br/>
    DOB : <input type="date" name="dob"> <br/>
    USD to Birr  : <input type="number" name="ExchangeRate">

    <c:set var="salary" scope="session" value="${2000*2}"/>
    <p><c:out value="${salary*24}"/>
        <
        <c:if test="${salary > 20000}" >
        <p> Software Developer salary  : <c:out value="average Salary">Average Salary</c:out> </p>
        </c:if>
    <c:if test="${salary<2000}">
        <p> Software Developer salary  : <c:out value="average Salary"> below Average Salary</c:out> </p>

    </c:if>
    <input type="submit" value="Submit">


</form>
</body>
</html>
