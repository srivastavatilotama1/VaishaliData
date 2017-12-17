<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
 prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

userListObj
<h3> Data is added in the table success\fully</h3>
<hr/>
<table border="1">
	<tr>
		<th>User Name</th>
		<th> First Name</th>
		<th> Last Name</th>
		<th> City </th>
		<th> Email</th>
	</tr>
	
	<c:forEach  var="userObj" items="${userListObj}">
		<tr>
			<td>${userObj.uname}</td>
			<td>${userObj.firstName}</td>
			<td>${userObj.lastName}</td>
			<td>${userObj.city}</td>
			<td>${userObj.email}</td>	
			<td><a href="displayEditUser.obj?uid=${userObj.uname}">Edit User</a></td>	
			<td><a href="">Delete User</a></td>	
		</tr>
	</c:forEach>
</table>
</body>
</html>