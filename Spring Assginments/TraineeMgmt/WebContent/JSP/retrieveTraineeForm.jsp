<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieve a Trainee</title>
</head>
<body>
	<center>
		<h1>Retrieve Operation</h1>
	</center>
	<c:url var="myAction" value="retrieveTrainee.obj"></c:url>
	<form:form action="${myAction}" method="post" modelAttribute="trainee">
	
	<table>
		<tr>
			<td>Please enter trainee ID</td>
			<td><form:input path="traineeId"></form:input></td>
			<td><input type="submit" value="retrieve" /></td>
		</tr>
	</table>
	</form:form>

	<c:if test="${traineeBean!=null}">
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		<h1 align="center">Trainee Info</h1>
		<table border="1" align="center">
		<tr>
			<th>Trainee Id</th>
			<th>Trainee Name</th>
			<th>Trainee Location</th>
			<th>Trainee Domain</th>
		</tr>
		<tr>
			<td><c:out value="${traineeBean.traineeId}" /></td>
			<td><c:out value="${traineeBean.traineeName}" /></td>
			<td><c:out value="${traineeBean.traineeLocation}" /></td>
			<td><c:out value="${traineeBean.traineeDomain}" /></td>
		</tr>
		</table>
	</c:if>
</body>
</html>