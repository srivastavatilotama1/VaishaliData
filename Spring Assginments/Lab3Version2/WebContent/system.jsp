<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Trainee Management System</h1>
<table border="1">
<tr><th colspan="6">Trainee Info</tr>
<tr>
<th>ID
<th>NAME
<th>LOCATION
<th>DOMAIN
<th colspan="2">OPERATION
</tr>
<c:forEach var="traineeList" items="${traineeList }">
<tr id="${traineeList.traineeId }">
<td>${traineeList.traineeId }
<td>${traineeList.traineeName }
<td>${traineeList.traineeLocation }
<td>${traineeList.traineeDomain }
<td><a href="removeTrainee.obj?traineeId=${traineeList.traineeId }" onclick="document.getElementById('${traineeList.traineeId }').innerHTML='''">Remove a Trainee</a>
<td><a href="modifyTrainee.obj?traineeId=${traineeList.traineeId }">Modify a Trainee</a>
</tr>
</c:forEach>
</table>
<p>Add a <a href="addTrainee.obj">new</a> trainee here</p>
</body>
</html>