<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<center>
		<h1>Login Page</h1>
		<form:form action="validateUser.obj" method="post" modelAttribute="login"> 
			<table>
				<tr>
					<td>Username</td>
					<td><form:input path="username" /></td>
					<td><form:errors path="username"></form:errors></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:password path="password" /></td>
					<td><form:errors path="password"></form:errors></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Login"/></td>
				</tr>	
			</table>
		</form:form>
	</center>
</body>
</html>