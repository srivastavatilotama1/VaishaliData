<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Registration.............</h1>

<form:form action="saveEmp.obj" method="post" commandName="newEmp" >
	<table border="1">
	<tr>
		<td>Employee Id:</td>
		<td> <form:input path="employeeId"/></td>	
		<td> <form:errors path="employeeId"/></td>	
	</tr>
	<tr>
		<td>First Name:</td>
		<td> <form:input path="firstName"/></td>	
	</tr>
	
	<tr>
		<td>Last Name:</td>
		<td> <form:input path="lastName"/></td>	
	</tr>
	
	<tr>
		<td>City:</td>
		<td> <form:select path="city" items="${locations}"/></td>	
	</tr>
	
	<tr>
		<td>Languages:</td>
		<td> <form:checkboxes path="prefLanguages" items="${langs}"/></td>	
	</tr>
	
	<tr>r
		<td>Marital Status:</td>
		<td> <form:radiobuttons path="maritalStaus" items="${marrStatus}"/></td>	
	</tr>
	
	<tr>
		<td>Salary:</td>
		<td> <form:input path="salary" /></td>	
	</tr>
	
	<tr>
		<td>Date Of joining:</td>
		<td> <form:input path="joinedDate" /></td>	
	</tr>
	
	<tr>
		<td colspan="2"> </td>	
		<td > <input type="submit" value="Register"/></td>	
		<td > <input type="reset" value="Reset"/></td>	
	</tr>	
		</table>
</form:form>

</body>
</html>