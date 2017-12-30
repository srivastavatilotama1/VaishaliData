 <%@ page  %>
<html>
  <head>
    <title></title>
  </head>
  <body bgcolor="cyan">   
  <h4>List All Emp Information</h4><br/>
    <table width="700"
      border="0" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th>Employee Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Salary</th>
      </tr>  
          <!-- iterate over the results of the query -->
		  <tr>
		  	<td> 111</td>
		  	<td> xxx </td>
		   	<td> 100000</td>
		  	<td><A href ="DeleteEmployeeServlet"> Delete Emp</A>
		  
		  	<td><A href ="EditEmployee.jsp"> Edit</A>
		  </tr>		  
		  
			  			  	
</table>

 <a href="AddEmployee.jsp">Add New Employee </A>
  </body>
</html>
