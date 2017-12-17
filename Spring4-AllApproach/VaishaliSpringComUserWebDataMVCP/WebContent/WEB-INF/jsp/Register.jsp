<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
 prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>${MsgObj}</h3>
<c:url var="regActionURL" 
value="insertUserDetails.obj"/>
<h1> Enter UR Registration Details</h1>
<form:form action="${regActionURL}" modelAttribute="user"
method="post">
	<table border="1">
		<tr>
			<td> FirstName:</td>
			<td><form:input path="firstName"/></td>
			<td></td>
		</tr>
		
		<tr>
			<td> LastName:</td>
			<td><form:input path="lastName"/></td>
			<td></td>
		</tr>
		
		<tr>
			<td> Gender:</td>
			<td>
				<form:radiobutton path="gender" 
				 value="M" label="Male"/>
				 <form:radiobutton path="gender" 
				 value="F" label="FeMale"/>
			</td>
			<td></td>
		</tr>
		
		<tr>
			<td> Email:</td>
			<td><form:input path="email"/></td>
			<td><form:errors path="email"/></td>
			<td></td>
		</tr>
				
		<tr>
			<td> SkillSet:</td>
			<td>
				<form:checkboxes 
				items="${skillList}" path="skillSet"/>
			</td>
			<td></td>
		</tr>	
		
		
		<tr>
			<td> City:</td>
			<td>
			<form:select path="city">
				<form:option value="" label="Select City"/>
				<form:options  items="${cList}"/>
			</form:select>
			</td>
			<td></td>
		</tr>	
		<tr>
			<td> Preffered User name:</td>
			<td><form:input path="uname"/></td>
			<td><form:errors path="uname"/></td>
			<td></td>
		</tr>
		
		<tr>
			<td> Password:</td>
			<td><form:input path="pwd"/></td>
			<td><form:errors path="pwd"/></td>
		</tr>
		
		<tr>
			<input type="submit" name="btnRegister"
			value="REGISTER"/>
		</tr>


	</table>
</form:form>
</body>
</html>