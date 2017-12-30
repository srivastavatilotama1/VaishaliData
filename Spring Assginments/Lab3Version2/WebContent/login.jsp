<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="showSystem.obj" modelAttribute="login">
<table>
<caption><h3>Login Page</h3></caption>
<tr>
<td>Username
<td><form:input path="username"></form:input>
<td><form:errors path="username"></form:errors>
</tr>
<tr>
<td>Password
<td><form:input path="password" type='password'></form:input>
<td><form:errors path="password"></form:errors>
</tr>
<tr>
<td>
<td><input type="submit" value="Login">
</tr>
</table>
</form:form>
</body>
</html>