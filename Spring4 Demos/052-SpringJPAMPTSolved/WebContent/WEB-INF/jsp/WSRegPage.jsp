<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
	<h2>Workshop Registration Form:  ${WID}</h2>
	<c:url var="myAction" value="/RegistrationSuccess.html"/>

 <form:form  action="${myAction}" method="get"  modelAttribute="participantModel">
 <table  border="1">
	 
 	<tr>	
 			<td> Name:</td>
 			<td><form:input path="name"/></td>
 			<td><form:errors path="name"/></td>
 	</tr>		
	<tr>	
 			<td> Email Id:</td>
 			<td><form:input path="emailId"/></td>
 			<td><form:errors path="emailId"/></td>
 	</tr>
 	<tr>	
 			<td> Mobile :</td>
 			<td><form:input path="mobile"/></td>
 			<td><form:errors path="mobile"/></td>
 	</tr>
 	
 	<tr>	
 			<td> Address :</td>
 			<td><form:input path="address"/></td>
 			<td><form:errors path="address"/></td>
 	</tr>	
	
	<tr>
		<td><input type="submit" value="REGISTER"/></td><td><input type="reset" value="CLEAR"/></td>
	</tr>			
	</table>
</form:form> 
 </body>
 </html>
