<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Login PAGE</h1>

<form action="loginSuccess.jsp" method="post">
<table>

 <tr><th colspan="3">Login Credentials</th></tr>
 <tr>
   <td>Username</td>
   <td><input type="text" name="userName"/></td>
   <td></td>
 </tr>
 <tr>
   <td>Password</td>
   <td><input type="text" name="password"/></td>
   <td></td>
 </tr>
 <tr>
   <td><input type="submit" value='Login'/></td>
 </tr>

</table>
</form>

</body>
</html>