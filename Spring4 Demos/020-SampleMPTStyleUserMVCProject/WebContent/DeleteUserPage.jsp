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
<body>
		<table border="1">
		<form:form action="updateUser.obj" modelAttribute="newUserUpdate">
			<tr>
				<td> UR User Name:</td>
				<td>${UserObject.userName}</td>
				<td></td>			
			</tr>
			
			<tr>
				<td> </td>
				<td><form:hidden path="userName" 
				 value="${UserObject.userName}"/></td>
				<td></td>			
			</tr>
			<tr>
				<td>  Existing password:</td>
				<td><form:input path="password" 
				 value="${UserObject.password}"/></td>
				<td></td>			
			</tr>
			
			<input type="submit" name="btnUpdate" value="Update User Details"/>
			
		</form:form>
		</table>
</body>
</html>