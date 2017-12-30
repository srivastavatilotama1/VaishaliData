<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
</head>
<body>
   <h1>Welcome To Log In Page</h1>
		<s:form action="Login">
			<%-- <s:textfield name="userName" label="Enter User Name:" /> --%>
			
			 <s:select name="userName" list="userNamelist" listKey="userName"
			listValue="userName" headerKey="0" headerValue="User Name"
			label="Select User Name:" />
						
			<s:password name="password" label="Enter Password:" />
			<s:submit />
		</s:form>
		
		<hr/>		
		<hr/>
		
		<s:iterator value="userNamelist">  
  			<p>User Name is: <s:property value="userName"/></p>  
		</s:iterator> 
		 <h4>.......................</h4>
	 
	  <s:set name="tempAge" value="age"/>
   
	
</body>
</html>