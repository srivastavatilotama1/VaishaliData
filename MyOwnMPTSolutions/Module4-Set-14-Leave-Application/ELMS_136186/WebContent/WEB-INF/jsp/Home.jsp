<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<style>
th, td {
    padding: 8px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
	<h1 align="center">Welcome to Leave Application</h1>
	<hr>
	<h2>${message }</h2>
	<form:form action="viewHistory.obj" modelAttribute="emp" method="post">
		<table align="center">
			<tr>
				<td><form:label path="empId">Enter Employee ID</form:label></td>
				<td><form:input path="empId" required="true"></form:input></td>
				<td><form:errors path="empId"></form:errors>
			</tr>
			<tr>
				<td colspan="2" align="right"><form:button type="submit">View Leave history</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>