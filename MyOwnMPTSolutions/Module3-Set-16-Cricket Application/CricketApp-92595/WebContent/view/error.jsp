<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- ---------------------------------------------------------------------- 
-File Name : error.jsp
-Author : Samyaka Dalvi
-Creation date : 10/04/2016
-Description : Displays error page.
--------------------------------------------------------------------------->    
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>





<body bgcolor="#ffe6e6">
	<center>
	<h3 style="color:red">Some error Occur : </h3>
	
	<br>
	<br>
	<p style="color:red">${error}</p>
	<br>
	<br>
	
	<a href="home.obj">Go to Home page</a>
	
	
	</center>
</body>
</html>