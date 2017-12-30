<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- userName object from value stack we can access -->
Login Successful...  <s:property value="userName"/>
You Can perform following   Operation For <br/> 

<s:form action="EmpOperation.action" >
		<s:submit />
		<s:submit action="addEmpOperation" value="Add Emp" />
		<s:submit action="updateEmpOperation" value="Update Emp" />
		<s:submit action="listallEmpOperation" value="List All Emp " />
		<s:submit action="deleteEmpOperation" value="Delete Emp" />		
</s:form>
 </body>
</html>