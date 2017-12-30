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
		<h3>Pay your Bill Here</h3>
		<br> <br>
		<h3>${UserDetails.name}</h3>
		<h4> Total Payment for the Mobile number : ${UserDetails.mobilenumber}</h4>
	<h4>	 IS : Rs.   ${UserDetails.billamount}</h4>
	
		</br>
	<c:set var="amt" value="${AMOUNT}" />
	Amount U Want To Pay Is: <c:out value="${amt}" />
	
	<c:set var="actualamt" value="${UserDetails.billamount}" />	
	
	 <form action="ProcessUser.do">
			<table>
				<tr>
					<td>Enter the amount to Pay</td>
					<td><input type="text" name="amount" />
					</td>
				</tr>

				<tr>
					<td>Enter the 10 digit card number</td>
					<td><input type="text" name="cardnumber" />
					</td>
				</tr>
			</table>
			<input type="submit" name="action" value="Pay">
			
	</form>
	
	<c:if test="${amt gt actualamt}"> 
 		  <c:out value="Sorry Amt to  pay is more than actula Amount" /> 	
	</c:if> 
	
	    <c:if test="${amt <= actualamt}"> 	    
	     <jsp:forward page="../ProcessUser.do">
	   		 <jsp:param value="Success" name="action"/>	   	 
	   	 </jsp:forward>  
	   	 
	   	 	<%--  <jsp:forward page="success.jsp"/>	 --%> 
		</c:if> 
	
	</center>
</body>
</html>