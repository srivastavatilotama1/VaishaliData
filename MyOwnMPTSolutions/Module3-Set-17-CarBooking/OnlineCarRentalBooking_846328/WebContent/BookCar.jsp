<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Purchase">
<table border=2>
<tr>
<td>
Enter  name:</td>
<td><input type="text" required  name="name"/></td></tr>
<tr><td>
Enter mail id:</td>
<td><input type="email" required  name="maildId"/></td></tr>
<tr><td>
Enter Mobile Number:</td>
<td><input type="text" required name="phoneno" pattern="[7-9]{1}[0-9]{9}"/></td></tr>
<tr><td>
Enter Address:</td>
<td><input type="text" required name="address"/></td></tr>
<tr><td colspan=2>
<input type="submit" value="Book Car"></td>
</tr>
</table>
</form>
</body>
</html>