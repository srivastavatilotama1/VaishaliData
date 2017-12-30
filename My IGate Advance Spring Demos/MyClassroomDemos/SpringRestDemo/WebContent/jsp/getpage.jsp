<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Get Employee</h1>

<c:if test="${empty employee}">
	No records found!
</c:if>

<c:if test="${!empty employee}">
	<table style="border: 1px solid #333">
		<tr>
		<td style="width: 150px">Id</td>
		<td>${employee.id}</td>
		</tr>
		
		<tr>
		<td>Employee Name   </td>
		<td>${employee.name}</td>
		</tr>
		
				
		<tr>
		<td>Email-ID</td>
		<td>${employee.email}</td>
		</tr>
	</table>
</c:if>

</body>
</html>