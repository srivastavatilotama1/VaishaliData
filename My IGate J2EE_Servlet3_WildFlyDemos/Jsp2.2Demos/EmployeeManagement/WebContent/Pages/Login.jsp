<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>  Employee Management Admin Login page</h3>
<form  action="EmployeeController?action=ValidateUser" method="post">
UserName:<input type="text" name="txtUName"
	value=""/><br/>
Password:<input type="password" name="txtPassword"
	value=""/>
<input type="submit" name="btnLogin"
value="ValidateUser"/>
</form>
</body>
</html>