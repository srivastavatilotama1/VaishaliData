<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
	<table border=2>
		<tr>
			<th>Car No</th>
			<th>CarType</th>
			<th>RentalPrice(rs)</th>
			<th>Status</th>
			<th>HireCar</th>
		</tr>
		<c:forEach var="CarDetails" items="${carlist}">
			<tr>
				<td>${CarDetails.carNumber}</td>
				<td>${CarDetails.carCategory}</td>
				<td>${CarDetails.hirePrice}</td>
				<td>${CarDetails.status}</td>
				
				<td><a href="Buy?carid=${CarDetails.carNumber}">Hire</a></td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>