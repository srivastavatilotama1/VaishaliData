<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="view/style.css"/> 
<title>Employee details</title>
</head>
<body background="<%=request.getContextPath()%>/images/image002.png">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<h2 align="center" style="color:blue;">Please Enter the Player Details:</h2>
<div>
<form action="CricketScoreController?action=store" method="post" align="centre">
<table align="center">
<tr>
<td>Enter player name: </td>
<td><input type="text" name="name" pattern="[A-Za-z]{3,}"  required /></td>
</tr>

<tr>
<td>Enter Dob: </td>
<td><input type="date" name="dob" required/></td>
</tr>

<tr>
<td>Select Team: </td>
<td>

<select name="team" required>
  <option value="India">India</option>
  <option value="UK">UK</option>
  <option value="SriLanka">Sri Lanka</option>
  <option value="Australia">Australia</option>
   <option value="Zimbawe">Zimbawe</option>
</select> 

</td>
</tr>

<tr>
<td>Batting Style:</td>
<td><input type="radio" name="batstyle" value="Left Handed Batsman" checked>Left Handed
<input type="radio" name="batstyle" value="Right Handed Batsman">Right Handed
</td>
</tr>

<tr>
<td>No of Centuries: </td>
<td><input type="text" name="century" required/></td>
</tr>

<tr>
<td>No of Matches Played: </td>
<td><input type="text" name="matchplayed" required/></td>
</tr>

<tr>
<td>Total Run Score: </td>
<td><input type="text" name="runscore" required/></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Save Player Data"/>
</td>
</tr>

</table>
</form>

</div>

<h2 align="center" style="color:purple;"><a href="CricketScoreController?action=fetch">Go to Home page</a></h2>

</body>
</html>