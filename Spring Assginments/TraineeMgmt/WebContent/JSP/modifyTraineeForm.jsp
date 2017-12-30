<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify a Trainee</title>
</head>
<body>
	<center>
		<h1>Modify Operation</h1>
	</center>
	<c:url var="myAction" value="modifyTrainee.obj"></c:url>
	<form:form action="${myAction}" method="post" modelAttribute="trainee">
	
	<table>
		<tr>
			<td>Please enter trainee ID</td>
			<td><form:input path="traineeId"></form:input></td>
			<td><input type="submit" value="modify" /></td>
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
		<form:form action="updateTrainee.obj" method="post" modelAttribute="traineeBean">
		<table border="1" align="center">
		<tr>
			<th>Trainee Id</th>
			<td><form:input path="traineeId" value="${traineeBean.traineeId}" /></td>
		</tr>
		<tr>
			<th>Trainee Name</th>
			<td><form:input path="traineeName" value="${traineeBean.traineeName}" /></td>
		</tr>
		<tr>
			<th>Trainee Location</th>
			<td><form:input path="traineeLocation" value="${traineeBean.traineeLocation}" /></td>
		</tr>
		<tr>
			<th>Trainee Domain</th>
			<td><form:input path="traineeDomain" value="${traineeBean.traineeDomain}" /></td>
		</tr>
		<tr>
			<td colspan="3" align="center"><input type="submit" value="update"/></td>
		</tr>
		</table>
		</form:form>
	</c:if>
</body>
</html>