<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	<tr>
		<th bgcolor="bisque">Cust Number</th>
		<th bgcolor="bisque">Base Pack</th>
		<th bgcolor="bisque">Optional Pack</th>
	</tr>
	<c:forEach var="CustList" items="${list}">
		<tr>
			<td><a href = "getCustomerDescription.obj?id=${CustList.custNum}">${CustList.custNum}</a></td>
			<td>${CustList.basePack}</td>
			<td>${CustList.optionalPack}</td>
			
		</tr>
	</c:forEach>

</table>
</body>
</html>


		