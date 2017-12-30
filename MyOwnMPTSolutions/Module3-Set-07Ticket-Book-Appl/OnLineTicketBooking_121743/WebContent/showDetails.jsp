<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--  ${list}-->

	<h1>List of Magic Shows</h1>
	<table border="1">

		<tr>
			<th>Show Name</th>
			<th>Location</th>
			<th>Date</th>
			<th>Price</th>
			<th>Available Seats</th>
			<th>Book</th>
		</tr>
		<a:forEach items="${list}" var="list">

			<tr>

				<td>${list.showname}</td>
				<td>${list.location}</td>
				<td>${list.showdate}</td>
				<td>${list.priceticket}</td>
				<td>${list.avseats}</td>


				<c:choose>
					<c:when test="${list.avseats < 1}">
						<td>Sold</td>
					</c:when>

					<c:when test="${list.avseats > 0}">
						<td><a
							href="book.do?id=${list.showid}&showname=${list.showname}&priceticket=${list.priceticket}&avseats=${list.avseats}&location=${list.location}&showdate=${list.showdate}">Book
								Now</a></td>
					</c:when>

					<c:otherwise>

					</c:otherwise>
				</c:choose>


			</tr>

		</a:forEach>
	</table>

</body>
</html>