<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
Welcome : <c:out value="${UserName}"></c:out>
<h3>Enter Emp Info</h3>
	<form action="EmployeeController?action=InsertEmp" method="post">
		Emp Id : <input type='text' 
		name='txtEId'
				value='<c:out value="${EmpId}"></c:out>' />
				<br/>
				
		Emp Name : <input type="text" name="txtEName"
				value="" /><br/>
				
		Emp Salary: <input type="text" name="txtESal"
				value="" /><br/>
		
<input type="submit" name="btmAddEmp" value="Add Emp"/>
	</form>
	<br/>
	<br/>
	<a href=""> Log Out</a>  
	<a href=""> List Emp</a>  
</body>
</html>