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
<body><h3> All User Info List**************************</h3>
<table border="1">
	<tr>
		<th>UserName</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>Email</th>
		<th>SkillSet</th>
		<th>City</th>
		<th>Gender</th>
		<th>Date Of Birth</th>
		<th>Do  U Want To edit?</th>
		<th> Do U want To Delete</th>
	
	<c:forEach var="us" items="${uDetailsList}">
	<tr>
		<td>${us.uname}</td>
		<td>${us.firstName}</td>
		<td>${us.lastName}</td>
		<td>${us.email}</td>
		<td>${us.skillSetStr}</td>
		<td>${us.city}</td>
		<td>${us.gender}</td>
		<td>${us.dobLocalDate}</td>
		<td><a href="displayEditUser.obj?uid=${us.uname}">Edit</a></td>
		<td><a href="displayDeleteUser.obj?uid=${us.uname}">Delete</a></td>
	</tr>
	</c:forEach>


</table>

</body>
</html>