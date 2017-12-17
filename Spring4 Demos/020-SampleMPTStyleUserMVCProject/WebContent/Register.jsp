<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
	<h2>Enter UR Login Details</h2>
<c:url var="myAction" value="/insertUserDetails.obj"/>

 <form:form  action="${myAction}" method="get"  
 modelAttribute="user">
 <table  border="1">
 	<tr>	
 			<td> First Name:</td>
 			<td><form:input path="firstName"/></td>
 			<td></td>
 	</tr>		
	<tr>	
 			<td> Last Name:</td>
 			<td><form:input path="lastName"/></td>
 			<td></td>
 	</tr>		
	<tr>	
 			<td> Gender:</td>
 			<td>
 				<form:radiobutton path="gender" value="M" label="M"/>
 				<form:radiobutton path="gender" value="F" label="F"/>
 			</td>
 			<td></td>
	</tr>		
	<tr>	
 			<td> Email:</td>
 			<td>
 				<form:input path="email"/> 				
 			</td>
 			<td><form:errors path="email"/></td>
	</tr>	
	
	<tr>	
 			<td> SkillSet :</td>
 			<td>
 				<form:checkboxes path="skillSet" items="${skillList}"/>	 				
 			</td>
 			<td></td>
	</tr>	
	<tr>	
 			<td> City:</td>
 			<td>
 				<form:select path="city">
 					<form:option value="" label="Select City"/>
 					<form:options items="${cList}"/> 					
 				</form:select>				
 			</td>
 			<td></td>
	</tr>		
	<tr>	
 			<td> Preffered User Name:</td>
 			<td>
 				<form:input path="uname"/> 				
 			</td>
 			<td><form:errors path="uname"/></td>
	</tr>		
	<tr>	
 			<td> Password:</td>
 			<td>
 				<form:password path="pwd"/> 				
 			</td>
 			<td><form:errors path="pwd"/></td>
	</tr>	
	<tr>	
 			<td> Confirm  Password:</td>
 			<td>
 				<form:password path="confirmPassword"/> 				
 			</td>
 			<td></td>
	</tr>	
	<tr>
   		<td>Date Of Birth:{dd-mm-yyyy} Format</td>
   		<td><form:input path="dobDateText"/></td>
   		<td><form:errors path="dobDateText" cssStyle="color:red"/></td>
	</tr>	
	<tr>
		<td><input type="submit" value="REGISTER"/></td>
	</tr>	
	</table>
</form:form> 
 </body>
 </html>
