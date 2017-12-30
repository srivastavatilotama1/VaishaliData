

<!--********************************************************************************
 * File					:Success.jsp
 * Author Name			:96121
 * Description			:JSP page to show successful complaint registration and provide 
 						 complaint Id to customer.Contains hyperlink to CheckStatus.jsp and
 						 RaiseComplaint.jsp
 * Version				:1.0
 * Create Date			:25-Nov-2016
 *********************************************************************************-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Success</title>
	</head>
	<body>
		<h3 align="center">Complaint Id for this request is ${complaintId}</h3>
		<h3 align="center">Thanks for raising a complaint</h3>
		<p align="center">
		<a href="checkStatusForm.html">Check Status</a>
		<a href="customerComplaintForm.html">Raise Complaint</a>
		</p>
	</body>
</html>