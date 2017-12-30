
<!--********************************************************************************
 * File					:index.jsp
 * Author Name			:96121
 * Description			:Welcome page to redirect to RaiseComplaintPage.jsp
 * Version				:1.0
 * Create Date			:25-Nov-2016
 *********************************************************************************-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome</title>
	</head>
	<body>
		<% response.sendRedirect("customerComplaintForm.html"); %>
	</body>
</html>