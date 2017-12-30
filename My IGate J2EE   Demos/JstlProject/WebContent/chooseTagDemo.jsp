<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<h3> Choose Tag Demo....</h3>

<form action="chooseTagDemo.jsp">
<select name="comboDay">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
</select>
<input type="submit" name="buttonSelectDay" value="Get Day"/>
</form>

<b>Today IS:</b>
<c:set var="varDay" value="${param.comboDay}"/>


<c:choose>
	<c:when test="${varDay==1}">Monday</c:when>
	<c:when test="${varDay==2}">Tuesday</c:when>
	<c:when test="${varDay==3}">Wednesday</c:when>
	<c:when test="${varDay==4}">Thursday</c:when>
	<c:when test="${varDay==5}">Friday</c:when>
	<c:when test="${varDay==6}">Saturday</c:when>
	<c:otherwise>Sunday</c:otherwise>
</c:choose>

</body>
</html>