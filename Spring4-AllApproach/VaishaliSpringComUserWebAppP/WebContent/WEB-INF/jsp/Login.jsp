  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	
	 prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
 prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${MsgObj}</h3>
<c:url var="myActionURL" value="validateLoginDetails.obj"/>
<h1>Enter UR Login Details</h1>
	<form:form action="${myActionURL}" method="post"
	 modelAttribute="login">
	 <table border="1">
		 <tr>
			<td>UserName:</td>
			<td><form:input path="userName" /> </td>
			<td><form:errors path="userName"/></td>
		</tr>
		<tr>
			<td> Password:</td>
			<td><form:input path="password"  /></td>
			<td><form:errors path="password"/></td>
		</tr>
		<tr>
			<td>
		 	 <input 	type="submit"
		 	  name=" btnLogin" value="LOGIN" />
			</td>
		</tr>
	</table>
	</form:form>
</body>
</html>