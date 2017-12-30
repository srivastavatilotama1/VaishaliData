<%@ page language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
  <head>
    <title></title>
  </head>
  <body bgcolor="pink">  
  <h5>Enter Employee Details.............</h5>  

<form:form action="addEmp.obj" method="post" commandName="newEmp">
	
	<table border="1">
	<tr>
		<td>Employee Id:</td>
		<td> <form:input path="eid"/></td>	
				<td style="color:red"> 				
				</td>	
	</tr>
	
	<tr>
		<td>First Name:</td>
		<td> <form:input path="firstName"/></td>
		<td> errr
			 <form:errors path="firstName" />
		 </td>		
	</tr>
	
	
	<tr>
		<td>Last Name:</td>
		<td> <form:input path="lastName"/></td>	
	<%-- 	<td> <form:errors path="lastName"></form:errors></td>	 --%>
	</tr>
	
	<tr>
		<td>City:</td>
		<td> <form:select path="city" items="${locations}"/></td>
		<td> error</td>		
	</tr>
	
	<tr>
		<td>Languages:</td>
		<td> <form:checkboxes path="prefLanguages" items="${langs}"/></td>	
		<td> error</td>	
	</tr>
	
	<tr>
		<td>Marital Status:</td>
		<td> <form:radiobuttons path="maritalStaus" items="${marrStatus}"/></td>	
	<td> error</td>	
	</tr>
	
	<tr>
		<td>Salary:</td>
		<td> <form:input path="salary" /></td>	
		<%-- <td> <form:errors path="salary"></form:errors></td>	 --%>
	</tr>
	
	<tr>
		<td>Date Of joining:(mm/dd/yyyy):</</td>
		<td> <form:input path="joinedDate" /></td>	
		<td> <%-- <form:errors path="joinedDate"></form:errors> --%></td>	
	</tr>
	
	
	<tr>
		<td>Email Address:</</td>
		<td> <form:input path="emailAddress" /></td>	
		<%-- <td><form:errors path="emailAddress"></form:errors></td>	 --%>
	</tr>
	
	<tr>
		<td>Mobile No:</</td>
		<td> <form:input path="mobileNo" /></td>	
		<%-- <td> <form:errors path="mobileNo"></form:errors></td>	 --%>
	</tr>
	
	<tr>
		<td colspan="2"> </td>	
		<td > <input type="submit" value="Add Emp"/></td>	
		<td > <input type="reset" value="Reset"/></td>	
	</tr>	
		</table>
		
</form:form>

  </body>
</html>
