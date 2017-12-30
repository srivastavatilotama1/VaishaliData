<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
    
<!------------------------------------------------------------------------- 
-File Name : viewPlayers.jsp
-Author : Samyaka Dalvi
-Creation date : 10/04/2016
-Description : Displays the retrieved data from database.
--------------------------------------------------------------------------->  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Players</title>
</head>


<body bgcolor="#FFF8DC">
<center>
	<table border="1" border-style="dotted">
	
	<tr>
	<th>Player Id</th>
	<th>Player Name</th>
	<th>Age (In yrs)</th>
	<th>Country</th>
	<th>Batting Style</th>
	<th>No of Centuries</th>
	<th>No of Matches Played</th>
	<th>Total Run Score</th>
	</tr>
	
		<c:forEach  var="player"  items="${playerList}">
		<tr>
		<td><c:out value="${player.playerId}"/></td>
		<td><c:out value="${player.playerName}"/></td>
		<td><c:out value="${player.age}"/></td>
		<td><c:out value="${player.country}"/></td>
		<td><c:out value="${player.battingStyle}"/></td>
		<td><c:out value="${player.centuries}"/></td>
		<td><c:out value="${player.matches}"/></td>
		<td><c:out value="${player.totalRunScore}"/></td>
		
		
		</tr>
		
		</c:forEach>
		</table>
		
		<a href="home.obj">Home page</a><br>
		
		<a href="add.obj">Add New Player</a><br>
		
		
		
	</center>

</body>
</html>