<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" bgcolor="pink">
<tr>
<td>Session Name</td>
<td>Duration(Days)</td>
<td>Faculty</td>
<td>Mode</td>
</tr>
<c:forEach items="${mydata}" var="empl">
<tr>
<td>${empl.tName}</td>
<td>${empl.tDuration}</td>
<td>${empl.tFaculty}</td>
<td>${empl.tMode}</td>
<td><a href="edit?id=${empl.tId}">UPDATE</a>
</tr>


</c:forEach>
</table>
</body>
</html>