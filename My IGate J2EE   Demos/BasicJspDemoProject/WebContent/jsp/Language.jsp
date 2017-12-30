<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<h4>Please Select UR Language</h4>
<form action="./GetComments.jsp">
Name:<input type="text" name="firstname" value=""/></br>
Your Preffered Language:
<select name="language">
	<option>Others</option>
	<option value="Java">Java</option>
	<option value="C">C</option>
	<option value="C++">C++</option>
	<option value="DotNet">DotNet</option>
</select></br>
<input type="submit" name="buttonComments"
 value="Get Comments"/>

</form>

</body>
</html>