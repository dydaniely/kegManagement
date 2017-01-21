<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Person Page</title>
		<style>
		.error{
			color:#cd0a0a;
		}
	</style>
</head>
<body>
 <form:form method="POST" modelAttribute="person">
	<form:input type="hidden" path="id" id="id"/>
	    <table>
		  <tr>
			  <td><label id="name">Name: </label> </td>
			  <td><form:input path="name" id="name"/> </td>
			  <td><form:errors path="name" cssClass="error"/> </td>
		  </tr>
		  <tr>
			  <td><label id="Country">Country Name</label></td>
			  <td><form:input path="country" id="country"/> </td>
			  <td><form:errors id="country" cssClass="error"/> </td>
		  </tr>
		  <tr>
			  <td colspan="3">
				  <c:choose>
					  <c:when test="${edit}">
						  <input type="submit" value="Update"/>
					  </c:when>
					  <c:otherwise>
						  <input type="submit" value="Register"/>
					  </c:otherwise>
				  </c:choose>
			  </td>
		  </tr>
	  </table>
 </form:form>
<br/>
<h2> Go back to </h2><a href="<c:url value='/list' />"> List Person</a>

</body>
</html>
