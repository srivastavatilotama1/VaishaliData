<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Show is Booked,below are details</h1>
	
		<table>
			<tr>
				<td>Show Name</td>
				<td>${sessionScope.showname }</td>
			</tr>
			<tr>
				<th>Customer Name</th>
				<td>${sessionScope.name }</td>
			</tr>
			<tr>
				<th>Mobile Number</th>
				<td>${sessionScope.mobile }</td>
			</tr>
			<tr>
				<th>No. of Seats </th>
				<td>${sessionScope.seats }</td>
			</tr>
			<tr>
				<td>Total Price</td>
				<td>>${sessionScope.totalprice }</td>
			</tr>
		</table>
	

<a href="showDetails.do">Go back to Home</a>
</body>
</html>