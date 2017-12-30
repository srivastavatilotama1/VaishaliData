<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
<body>
Welcome : <c:out value="${UserName}"></c:out>
<table border="1">
<tr>
	<th>EmpId</th>
	<th>Emp Name</th>	
</tr>
<c:forEach var="empObj" items="${EmpList}">
	<tr>
		<td>${empObj.empId}</td>
		<td>${empObj.empName}</td>		
	</tr>
</c:forEach>
</table>
<a href=""> Do U Want To Add Again</a><br/>
<a href=""> LogOut</a>

</body>
</html>