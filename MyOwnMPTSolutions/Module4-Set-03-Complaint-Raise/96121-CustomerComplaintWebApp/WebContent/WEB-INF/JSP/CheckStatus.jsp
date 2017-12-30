

<!--********************************************************************************
 * File					:CheckStatus.jsp
 * Author Name			:96121
 * Description			:JSP form to accept complaint Id from customer and display
 						 status of complaint.Contains hyperlink to RaiseComplaint.jsp
 * Version				:1.0
 * Create Date			:25-Nov-2016
 *********************************************************************************-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Check Status</title>
	</head>
	<body>
		<h1 align="center">Check Status</h1>
		<hr>
		<form action="processCheckStatusForm.html",method="get">
			<table align="center">
				<tr>
					<td>Complaint Id:</td>
					<td><input type="text" name="complaintId"/></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" value="Check Status">
					</td>
				</tr>
				<tr>
					<td style="color: red" colspan="2"	align="center">
						${message}
					</td>
				</tr>
			</table>
		</form>
		<f:form modelAttribute="complaint">
			<table align="center" border="1">
				<tr>
					<td>Complaint Id</td>
					<td>Description</td>
					<td>Status</td>
				</tr>
				<tr>
					<td>${complaint.complaintId}</td>
					<td>${complaint.description}</td>
					<td>${complaint.status}</td>
				</tr>
			</table>
		</f:form>
		<p align="center"><a href="customerComplaintForm.html">Raise Complaint</a></p>
	</body>
</html>