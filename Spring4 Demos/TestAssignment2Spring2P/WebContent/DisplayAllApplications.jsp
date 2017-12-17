   <%@ page import="java.util.*,com.igate.jdbc.bean.Application" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title></title>
  </head>
  <body bgcolor="cyan">   
  <h4>All Appliaction Information</h4><br/>
    <table width="700"
      border="1" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th>Application Id</th>
        <th>User Name</th>
        <th>Email</th>
        <th>Mobile </th>
        <th>City</th>
        <th>Application Date</th>
        <th>Does Account Exists</th>
       
      </tr>
  <c:forEach items="${listApp}" var="app">
      <tr>      
      	<td>${app.applicationId}</td> 
      	<td>${app.username}</td>  
      	<td>${app.emailId}</td>  
      	<td>${app.mobileNumber}</td>  
      	<td>${app.city}</td>  
      	<td>${app.appliedDate}</td>  
      	<td>${app.accountExists}</td> 
        <td>
        	<a href="displayEditApplicationJsp.obj?appId=${app.applicationId}">
        		Edit 
        	</A>
        </td> 
        <td></td>
        <td>
        	<a href="ApplicationController.do?action=displayDeleteAppJsp?appId=${app.applicationId}">
        		Delete
             </A>
        </td> 
      </tr>
      </c:forEach>  	 
</table> 
hello.................List

</br></br>
 <a href="showCreaditApplication.obj">Add New Application </A>
  </body>
</html>
