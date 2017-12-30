<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Student Marks Information</h3>
<form method="post" action="./CalculateGrade.jsp">

Roll No: <input type="text" name="rollNo"
		value=""/><br/>
Student Name: <input type="text" name="stuName"
		value=""/><br/>
Marks : <input type="text" name="marks"
		value=""/><br/>
		<input type="submit" name="btmCalcGrade" value="  
	Calculate Grade"/>
</form>
</body>
</html>