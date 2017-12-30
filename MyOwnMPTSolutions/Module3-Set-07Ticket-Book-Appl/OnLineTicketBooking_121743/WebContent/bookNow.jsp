<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Booking Form</h1>
	<form action="updateDeatils.do">
		<table>
			<tr>
				<td>Show Name</td>
				<td><input type="text" value="${list.showname}" name="showname"
					readonly="readonly" required/></td>
			</tr>
			<tr>
				<td>Price Per Ticket</td>
				<td><input type="text" value="${list.priceticket}"
					name="priceticket" readonly="readonly" required/></td>
			</tr>

			<tr>
				<th>Customer Name</th>
				<td><input type="text" name="name" pattern="[a-zA-Z]{1,}" required/></td>
			</tr>
			<tr>
				<th>Mobile Number</th>
				<td><input type="text" name="mobile"  pattern="[1-9]{1}[0-9]{9}" required/></td>
			</tr>
			<tr>
				<th>Seats Available</th>
				<td><input type="text" value="${list.avseats}" name="avseats"
					readonly="readonly" required/></td>
			</tr>
			<tr>
				<th>No. of Seats to Book</th>
				<td><input type="text" name="seats" pattern="[1-9]{1}[0-9]{0,}" required/></td>
			</tr>

		</table>
		<input type="submit" value="BOOK">
	</form>

</body>
</html>