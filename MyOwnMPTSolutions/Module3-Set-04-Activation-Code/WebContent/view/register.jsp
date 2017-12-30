<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>YESCorp Firm Registration System</title>
</head>
<body bgcolor=#DFDDCD>
<center>
	<h2>Register New USer</h2>
	<br>
	<b>On Submission you will recieve a verification code for activation</b>
	<br>
<form method="post" action="FirmRegistration?operation=register">
	<table align="center">
		<tr><td colspan="1"></td><td>First Name</td><td>Middle Name</td><td>Last Name</td></tr>
		<tr><td>* Name :</td><td><input type="text" name="firstName" id="firstName" required></td>
		<td><input type="text" name="middleName" id="middleName" required></td>
		<td><input type="text" name="lastName" id="lastName" required></td></tr>
		<tr><td>* Business Name :</td><td><input type="text" name="businessName" id="businessName" required></td></tr>
		<tr><td>* Email-Id :</td><td><input type="email" name="emailId" id="emailId" required></td></tr>
		<tr><td>* Mobile Number</td><td><input type="text" name="mobileNumber" id="mobileNumber" required></td></tr>
		<tr><td colspan="3"></td><td><input type="submit" name="Register" value="Register"><input type="reset" name="reset" value="Reset">
	</table>
</form>
</center>
<c:if test="${sessionScope.errorList ne null}">
	<h5>NOTE:</h5>
	<ol class="err">
		<c:forEach var="error" items="${errorList}">
			<li>${error}</li> 
		</c:forEach>
	</ol>
</c:if><br/>
</body>
</html>