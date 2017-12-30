<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Output</title>
<link rel="stylesheet" type="text/css" href="view/style.css"/>
</head>
<body background="<%=request.getContextPath()%>/images/image001.jpg">

<h2 style="color:blue;" align="center">Player Details:</h2>
	<table border="2" style="color:red; width: 50%; margin-left: auto; margin-right: auto;">
	
		<tr>
			<th>Player_ID</th>
			<th>Player Name</th>
			<th>Age</th>
			<th>Country</th>
			<th>Batting style</th>
			<th>No of Centuries</th>
			<th>No of matches played</th>
			<th>Total run Score</th>
			
		</tr>
			<c:forEach items="${CricList}" var="cric">
				<tr>
					<td><c:out value="${cric.getPlayerId()}" /></td>
					<td><c:out value="${cric.getPlayerName()}" /></td>
					<td><c:out value="${cric.getAge()}" /></td>
					<td><c:out value="${cric.getTeam()}" /></td>
					<td><c:out value="${cric.getBattingstyle()}" /></td>
					<td><c:out value="${cric.getCenturies()}" /></td>
					<td><c:out value="${cric.getMatchesplayed()}" /></td>
					<td><c:out value="${cric.getTotalScore()}" /></td>
				</tr>
			</c:forEach>
	</table>


<br>

<h2 align="center"><a href="CricketScoreController?action=insert">Add New Player</a></h2>


</body>
</html>
