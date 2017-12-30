<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="false" errorPage="errors.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
   <script type="text/javascript" language="javascript" src="../js/validation.js">	

</script>
</head>
<body bgcolor="skyblue">
	<center>
		<h2>AirSpace Telecomm</h2>
		<br>
		<h3>New User Registration Form</h3>
		<br> <br>


	         	<form name="RegisterUserForm" action="ProcessUser.do" method="get"  onSubmit="return validation();">
			<table>
				<tr>
					<td>Enter your Name :</td>
					<td><input type="text" name="custName" /></td>
					<td ><div id="custNameId"></div></td>
				</tr>
				<tr>
					<td>Mobile Number :</td>
					<td><input type="text" name="mobileNo" /></td>						
					<td ><div id="mobileNoId"></div></td>
				</tr>
				<tr>
					<td>Username :</td>
					<td><input type="text" name="uName" /></td>
					<td ><div id="uNameId"></div></td>
				</tr>
				<tr>
				   	<td>Password :</td>
					<td><input type="text" name="pass" /></td>
					<td ><div id="passId"></div></td>
				</tr>

				<tr>
					<td>Re-enter Password :</td>
					<td><input type="text" name="rePass" /></td>
					<td ><div id="rePassId"></div></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" name="action" 
					value="Register" ></td>
				</tr>
			</table>
		</form>



	</center>
</body>
</html>