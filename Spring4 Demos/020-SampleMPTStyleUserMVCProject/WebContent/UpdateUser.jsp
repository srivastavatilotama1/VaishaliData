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
<body>
		<table border="1">
		<form:form action="updateUser.obj" modelAttribute="newUserDetailUpdate">
			<tr>
				<td> UR User Name:</td>
				<td>${UserDetailsObject.uname}</td>
				<td></td>			
			</tr>
			
			<tr>
				<td> </td>
				<td><form:hidden path="uname" 
				 value="${UserDetailsObject.uname}"/></td>
				<td></td>			
			</tr>
			<tr>
				<td>  Existing password:</td>
				<td><form:input path="pwd" 
				 value="${UserDetailsObject.pwd}"/></td>
				<td></td>			
			</tr>
			<tr>
				<td>  LastName:</td>
				<td><form:input path="lastName" 
				 value="${UserDetailsObject.lastName}"/></td>
				<td></td>			
			</tr>
			
			<tr>
				<td>  Email:</td>
				<td><form:input path="email" 
				 value="${UserDetailsObject.email}"/></td>
				<td></td>			
			</tr>
			
			<tr>	
 				<td> SkillSet :</td>
 				<td>
 					<form:checkboxes path="skillSet" items="${skillList}"/>	 				
 				</td>
 				<td></td>
			</tr>	
			
			<input type="submit" name="btnUpdate" value="Update User Details"/>
			
		</form:form>
		</table>





</body>
</html>