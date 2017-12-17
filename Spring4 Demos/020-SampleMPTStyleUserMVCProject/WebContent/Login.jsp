<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
	<h2>Enter UR Login Details</h2>

<c:url var="myAction" value="/validateLoginDetails.obj"/>

 <form:form  action="${myAction}" method="get"  
 modelAttribute="login">
 <table  border="1">
 	<tr>
		<td>Enter User Name:</td>
		<td><form:input path="userName"/></td>
		<td><font color="red"><form:errors path="userName"/></font></td>
	</tr>
	<tr>
		<td>Enter Password:</td>
		<td><form:input path="password"/></td>
  		<td><font color="red"><form:errors path="password"/></font></td>
	</tr>
	<tr>
		<td><input type="submit" value="LOGIN"/></td>
	</tr>	
	</table>
</form:form>
 

 
 </body>
 </html>
