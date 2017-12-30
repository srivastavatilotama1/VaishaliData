<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Greet.jsp" method="post">
Select Name:

<select name="txtName">
	<option value="Sam">SAM</option>
	<option value="Ram">RAM</option>
</select>
<input type="submit" name="submit" value="Greet "/>
</form>

<c:set var="uname" value="${param.txtName}"/>
<c:if test="${uname=='Sam'}">
	<c:out value="Good Morning SAM"/>
</c:if>

<c:if test="${uname=='Ram'}">
	<c:out value="Good Afternoon RAM"/>
</c:if>
<hr/>
<c:forEach var="i" begin="1" end="10" step="2">
	<c:out value="${i}"/><br/>
</c:forEach>
<hr/>
<%!
	ArrayList<String> empNameList=new ArrayList<String>();	
%>
<%
	empNameList.add("Vaishali");
	empNameList.add("Sanskrity");
	empNameList.add("Nikita");
	empNameList.add("Sumit");
	session.setAttribute("empList", empNameList);
%>
<a href="ShowNameList.jsp">Show Emp Name List</a>
</body>
</html>