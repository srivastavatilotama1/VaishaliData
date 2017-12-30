<%@ page language="java" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
  <head>
    <title></title>
  </head>

  <body>
   
   <form:form action="editEmp.obj" method="post" commandName="newEmp" >
      <table width="500" border="0">
       
        <tr>
         	 <td>Employee Id</td>
      		 <td> ${EmpObj.eid} </td> 
      		  <td><form:hidden path="eid" value="${EmpObj.eid}"/> </td> 
      		<td> error</td>	
      		 	    		
        </tr> 
        
        <tr>
          <td>Employee  First Name</td>
          <td><form:input path="firstName" value="${EmpObj.firstName}" /></td> 
          <td> error</td>	
        </tr>
        
        <tr>
          <td>Employee Last  Name</td>
         <td><form:input path="lastName"  value="${EmpObj.lastName}"/></td>
         <td> error</td>	
        </tr>
        
        <tr>
          <td>Employee City</td>
          <td><form:select path="city" items="${locations}"/></td> 
          <td> error</td>	
        </tr>
        
         <tr>
          <td>Employee Preferred language</td>
          <td><form:checkboxes path="prefLanguages" items="${langs}" /></td>
          <td> error</td>	
        </tr>
        
         <tr>
          <td>Marrial status</td>
           <td> <form:radiobuttons path="maritalStaus" items="${marrStatus}"/></td>
           <td> error</td>	 
        </tr>
        
      
        <tr>
          <td>Employee Salary</td>
         <td><form:input path="salary" value="${EmpObj.salary}"/></td> 
         <td> error</td>	
        </tr>
        
         <tr>
          <td>Date Of Joining(mm/dd/yyyy)</td>
         <td> <form:input path="joinedDate" 
         value="${EmpObj.joinedDate}"  /></td> 
         <td> error</td>	
        </tr>      
        
        <tr>
          <td> <input type="submit" name ="submit" value="Update"> </td>
        </tr>
        
      </table>

</form:form>
  </body>
</html>
