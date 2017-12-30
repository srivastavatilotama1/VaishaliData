<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Enter Trainee Details</h1>
<c:url var="myAction" value="insertTrainee.obj" />
<form:form method="post" action="${myAction }" modelAttribute="trainee">
<table>
<tr>
<td>Trainee Id
<td><form:input path="traineeId"/>
<td style="color: red;"><form:errors path="traineeId"></form:errors></td>
</tr>
<tr>
<td>Trainee Name
<td><form:input path="traineeName"/>
<td style="color: red;"><form:errors path="traineeName"></form:errors></td>
</tr>
<tr>
<td>Trainee Location
<td><form:radiobutton path="traineeLocation" value="Chennai" label="Chennai"/>
<form:radiobutton path="traineeLocation" value="Bangalore" label="Bangalore"/>
<form:radiobutton path="traineeLocation" value="Pune" label="Pune"/>
<form:radiobutton path="traineeLocation" value="Mumbai" label="Mumbai"/>
<td style="color: red;"><form:errors path="traineeLocation"></form:errors></td>
</tr>
<tr>
<td>Trainee Domain
<td><form:select path="traineeDomain">
<form:option value="" label="Select a Domain"></form:option>
<c:forEach var="domainList" items="${domList }">
<form:option value="${domainList}" label="${domainList }"></form:option>
</c:forEach>
</form:select>
<td style="color: red;"><form:errors path="traineeDomain"></form:errors></td>
</tr>
<tr>
<td><input type="submit" value="Add Trainee">
<td>
</tr>
</table>
</form:form>
</body>
</html>