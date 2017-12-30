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
	<form method="post" action="FirmRegistration?operation=activation">
		<table>
			<tr>
				<td>* Email id:</td>
				<td><input type="email" name="emailId" id="emailId" required></td>
			</tr>
			<tr>
				<td>* Activation Code :</td>
				<td><input type="text" name="activationCode" id="actCode"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="activate" value="Activate"><input
					type="reset" name="Reset" value="Reset"></td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>