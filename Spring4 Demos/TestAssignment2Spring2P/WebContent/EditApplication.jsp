<%@ page language="java" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
  <head>
    <title></title>
  </head>

  <body>
   
   <form:form action="editApp.obj" method="post" commandName="newApp">
      <table width="500" border="0">
       
        <tr>
         	 <td>Application  Id:${AppObj.applicationId} <td>
      		 <td> ${AppObj.applicationId} </td> 
      		  <td><form:hidden path="applicationId" value="${AppObj.applicationId}"/> </td> 
      		<td> error</td>	
      		 	    		
        </tr> 
        
        <tr>
          <td>User Name</td>
          <td><form:input path="username" value="${AppObj.username}" /></td> 
          <td> error</td>	
        </tr>
        
       <tr>
          <td>  Email</td>
         <td><form:input path="emailId"  value="${AppObj.emailId}"/></td>
         <td> error</td>	
        </tr>
        
        <tr>
          <td>  Mobile</td>
         <td><form:input path="mobileNumber" value="${AppObj.mobileNumber}" /></td>
         <td> error</td>	
        </tr> 
             
        <tr>
          <td> <input type="submit" name ="submit" value="Update"> </td>
        </tr>
        
      </table>

</form:form>
  </body>
</html>
