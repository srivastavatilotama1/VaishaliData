<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retrieve All Trainees</title>
</head>
<body>
	<center>
		<h1>Trainees Details</h1>
		<table border=1>
			<tr>
				<th>Trainee ID</th>
				<th>Trainee Name</th>
				<th>Trainee Location</th>
				<th>Trainee Domain</th>
			</tr>
			<c:forEach var="traineeList" items="${list}">
			<tr>
				<td>${traineeList.traineeId}</td>
				<td>${traineeList.traineeName}</td>
				<td>${traineeList.traineeLocation}</td>
				<td>${traineeList.traineeDomain}</td>
		
			</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>