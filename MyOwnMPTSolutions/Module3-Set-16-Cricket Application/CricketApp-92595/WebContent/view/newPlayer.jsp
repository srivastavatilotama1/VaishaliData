<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!-- ---------------------------------------------------------------------- 
-File Name : newPlayer.jsp
-Author : Samyaka Dalvi
-Creation date : 10/04/2016
-Description : Displays a form to add a new player.
--------------------------------------------------------------------------->  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="view/newPlayer.css"></link>
<title>Add Player</title>
</head>

<body>
	<center>
		<form action="newPlayer.obj" method="post" id="data">
			<table class="tab">

				<tr>
					<td >Enter Player Name :(*)</td>
					<td><input type="text" name="ename" required /></td>
				</tr>

				<tr>
					<td>Enter DOB :(*)</td>
					<td><input type="date" name="edob" required/></td>
				</tr>

				<tr>
					<td>Select Team :(*)</td>
					<td><select name="eloc" required>
							<option>India</option>
							<option>UK</option>
							<option>SriLanka</option>
							<option>Australia</option>
							<option>Zimbawe</option>
					</select></td>
				</tr>


				<tr>
					<td>Batting Style :(*)</td>

					<td><input type="radio" name="style" value="Left Handed" checked/>Left Handed</td>

					<td><input type="radio" name="style" value="Right Handed" />Right Handed</td>
				</tr>


				<tr>
					<td>Number of Centuries :(*)</td>
					<td><input type="text" name="centuries" required pattern="\d*"/></td>
				</tr>
				
				<tr>
					<td>Number of Matches Played :(*)</td>
					<td><input type="text" name="matches" required pattern="\d*"/></td>
				</tr>
				
				<tr>
					<td>Total Run Score :(*)</td>
					<td><input type="text" name="runs"  min="0" required pattern="\d*" title="Score should be greater than 0"/></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Save Player Data" /></td>
				</tr>

			</table>
		</form>
	</center>

</body>
</html>