<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 12/29/2016
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Addis Ababa univeristy student registration form</title>
<form:form method="post" action="Students/addStudent" >
    <table>
        <tr>
    <td><form:label path="name">Name</form:label></td>
    <td><form:input path="name"></form:input></td>
        </tr>
    <tr>
    <td> <form:label path="age">Age</form:label></td>
    <td><form:input path="age"></form:input></td>
    </tr>
        <tr><td> <input type="submit" value="Submit"> </td></tr>
    </table>
</form:form>

    


<table>
    <tr bgcolor="#deb887">
    <th>First Name</th><th>Last Name</th>
    </tr>
<%
    Enumeration paEnumeration= request.getParameterNames();
    while(paEnumeration.hasMoreElements()){
        String paramName= (String) paEnumeration.nextElement();
        out.print("<tr><td>" + paramName + "</td>\n");
        String paramValue = request.getHeader(paramName);
        out.println("<td> " + paramValue + "</td></tr>\n");
    }
%>
</table>
    <p><b>First Name : <%=request.getParameter("First_name")%></b></p>
        <p><b>Last Name : <%=request.getParameter("Last_name")%></b></p>
        <p><b>Last Name : <%=request.getParameter("dob")%></b></p>
</head>
<body>

</body>
</html>
