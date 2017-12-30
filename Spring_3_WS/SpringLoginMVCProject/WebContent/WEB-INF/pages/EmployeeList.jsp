   <%@ page import="java.util.*,com.igate.bean.Employee" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title></title>
  </head>
  <body bgcolor="cyan">   
  <h4>All Emp Information</h4><br/>
    <table width="700"
      border="1" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th>Employee Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>City </th>
        <th>Preff lang</th>
        <th>Marrital Staus</th>
        <th>Salary</th>
        <th>DOJ</th>
      </tr>
  <c:forEach items="${empList}" var="emp">
      <tr>      
      	<td>${emp.eid}</td>
       	<td>${emp.firstName}</td>
        <td>${emp.lastName}</td>
        <td>${emp.city}</td>
        <td>${emp.prefLanguages}</td>
        <td>${emp.maritalStaus}</td>
        <td>${emp.salary}</td>
        <td>${emp.joinedDate}</td> 
        <td>
        	<a href="displayEditEmpJsp.obj?empId=${emp.eid}">
        		Edit 
        	</A>
        </td> 
        <td></td>
        <td>
        	<a href="EmployeeController.do?action=displayDeleteEmpJsp?empId=${emp.eid}">
        		Delete
             </A>
        </td> 
      </tr>
      </c:forEach>  	 
</table> 
hello.................List

</br></br>
 <a href="getEmpForm.obj">Add New Employee </A>
  </body>
</html>
