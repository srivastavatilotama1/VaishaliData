<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<center>
   <h2>AirSpace Telecomm</h2>
		<br>
		<h3>Welcome ${UserDetails.name}</h3>
		<br>
		<br>
		<form action="ProcessUser.do">
		 <h4><pre>The pending bill amount for your
		   Mobile Number   :   ${UserDetails.mobilenumber}
		     is   : Rs.   ${UserDetails.billamount}</pre></h4><br><br>
			<input type="submit" name="action" value ="PayBill">
		</form>
</center>
</body>
</html>