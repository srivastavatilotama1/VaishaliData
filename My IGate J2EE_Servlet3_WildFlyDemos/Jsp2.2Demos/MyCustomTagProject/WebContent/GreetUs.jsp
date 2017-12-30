<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html 
PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  uri="linktogreet"  prefix="igate" %>
<html>
<head>
<meta http-equiv="Content-Type"
 content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hi from Html h1</h1>
<hr/>

<igate:greet username="Vaishali"> Greet says Hi</igate:greet>
<hr/>
<%= " Hello from Jsp" %>

<igate:greet> Greet says Hi</igate:greet>
</body>
</html>


