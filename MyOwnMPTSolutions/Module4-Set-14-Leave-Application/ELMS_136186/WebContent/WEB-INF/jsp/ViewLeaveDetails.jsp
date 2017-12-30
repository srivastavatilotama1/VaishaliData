<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Details</title>
<style>
#header {
	margin-right: 100px;
	margin-left: 100px;
}

th, td {
	padding: 8px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
	<div align="center" id="header">
		<h1>Leave History Details</h1>
		<h3>Employee ID: ${empId} Employee Name: ${empName }</h3>
	</div>
	<hr>
	<c:if test="${leaves ne null }">
		<table align="center" style="text-align: center;">
			<tr>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Description</th>
				<th>No of Days</th>
			</tr>

			<c:forEach items="${leaves }" var="leave">
				<tr>
					<td>${leave.startDate }</td>
					<td>${leave.endDate }</td>
					<td>${leave.description }</td>
					<td>${leave.leavesApplied }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<h2>${message}</h2>
</body>
</html>