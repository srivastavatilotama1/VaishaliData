<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <title>Registration Page.</title>
        <STYLE type="text/css">  
               .errorMessage{color:red;}  
        </STYLE>

</head>
<body bgcolor="pink">	
	<h1><s:text name="global.heading"/></h1>
	
	  <s:url id="indexEN" namespace="/" action="locale" >
      <s:param name="request_locale" >en</s:param>
   </s:url>
   <s:url id="indexFR" action="locale" >
      <s:param name="request_locale" >fr</s:param>
   </s:url>
   <s:url id="indexJR" namespace="/" action="locale" >
      <s:param name="request_locale" >jr</s:param>
   </s:url>
   <s:url id="indexHN" namespace="/" action="locale" >
      <s:param name="request_locale" >hn</s:param>
   </s:url>
	
	
	<s:a href="%{indexEN}" >English</s:a>
   <s:a href="%{indexFR}" >France</s:a>
   <s:a href="%{indexJR}" >Jerman</s:a> 
    <s:a href="%{indexHN}" >Hindi</s:a> 
	
	
	<s:div>Register Your Self</s:div>
	
	<s:text name="Please fill in the form below:" />
	
	<s:form action="populateRegister" method="post"
		enctype="multipart/form-data">
		
		<%--  <s:textfield key="userName" label="Preferred User Name:" />  --%>
		 <s:textfield key="userName"  /> 
		 
		<s:password name="password" label="Enter Password:" />
		
		<s:password name="confirmPassword" label="Retype  Password:" />
		
		<s:textfield name="firstName" label="First Name:" />
		
		<s:textfield name="lastName" label="Last Name:" />
		
	<%-- <s:textfield name="age" label="Age:" />  --%>
		 <s:textfield key="age"  />		
		
		<s:textfield name="phoneNo" label="Enter Phone No:" />
		
		<s:radio label="Gender" name="gender" list="{'Male','Female'}" />
		
		<%-- <s:checkboxlist label="Hobbies" name="hobbies"
			list="{'sports','tv','shopping'}" /> --%>
						
		<s:checkboxlist label="Hobbies" name="hobbies"
			list="hobbies" />
			
		 <s:select name="country" list="countryList" listKey="countryName"
			listValue="countryName" headerKey="0" headerValue="Country"
			label="Select a country" /> 			
			
		<s:textarea name="about" label="About You" />
		
		<s:checkboxlist list="communityList" name="community"
			label="Community" />
			
		<s:checkbox name="mailingList"
			label="Would you like to join our mailing list?" />
		<s:textfield name="emailAddress" label="Email :" />
		<s:textfield name="dob" label="Date Of Birth:(mm/dd/yyyy):" />
		<%-- <s:submit /> --%>		
		 <s:submit name="submit" key="global.submit" />
		
	</s:form>

</body>
</html>