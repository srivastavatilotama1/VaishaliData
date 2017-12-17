<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>List Of  Scheduled Workshop</h1>		
		<c:if test="${workshopList ne null}">
			<table border="1">
				<tr>					
					<th>Topic Name</th>
					<th>Date</th>
					<th>Venue</th>
					<th>Do U Want To Register?</th>
				</tr>
				<c:forEach items="${workshopList}" var="workshop">
					<tr>
						<th>${workshop.workshopName}</th>
						<th>${workshop.schDate}</th>
						<th>${workshop.venue}</th>
						<td><a href="findAvailableWS.html?wid=${workshop.workshopId}">Register</a></td>
						
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>