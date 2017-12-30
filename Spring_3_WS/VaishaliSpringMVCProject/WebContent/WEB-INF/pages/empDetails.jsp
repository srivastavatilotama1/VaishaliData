<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Details are saved in database</h3>
<table border="1">

	<tr>
			<td>${newEmp.employeeId}</td>
			<td>${newEmp.firstName}</td>
			<td>${newEmp.lastName}</td>
			<td>${newEmp.city}</td>
			<td>			
				<c:forEach var="lang" items="${newEmp.prefLanguages}">
				${lang}
				</c:forEach>					
			</td>
			<td>${newEmp.maritalStaus}</td>
			<td>${newEmp.salary}</td>
			<td>${newEmp.joinedDate}</td>
	</tr>
</table>
</body>
</html>