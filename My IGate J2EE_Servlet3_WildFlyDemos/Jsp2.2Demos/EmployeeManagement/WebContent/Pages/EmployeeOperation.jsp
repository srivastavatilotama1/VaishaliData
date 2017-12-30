<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>
 Welcome To Employee Management System:  
  <font color="green"><c:out value="${UserName}"></c:out></font>
  
  <br/>
  <a href="EmployeeController?action=DisplayAddEmpPage">Add Emp</a></br>
    <a href="">Update Emp</a></br>
      <a href="">Delete Emp</a></br>
        <a href="EmployeeController?action=ListAllEmp">List Emp</a></br>
</body>
</html>