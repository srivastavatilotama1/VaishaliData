<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="FeedbackController?action=ValidateRole" method="post">
Enter Your Name <input type="text" name="userName"><br>
Select Role : <select name="role">
<option value="student">Student</option>
<option value="admin">admin</option>
</select><br>
<input type="submit"  name="btnLogin" value="login"/>
<input type="Reset"/>
 </form>

<br>

Your login page Visited  Count  : ${visitCount}

</body>
</html>