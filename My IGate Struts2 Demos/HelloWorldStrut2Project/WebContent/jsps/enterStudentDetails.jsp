<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <title>Student Details </title>
       
        <STYLE type="text/css">  
               .errorMessage{color:red;}  
        </STYLE>

</head>
<body bgcolor="pink">	
		
	
	<s:div>Enter Student Details</s:div>
	
	<s:form action="getStudentGrade.action" method="post"
		enctype="multipart/form-data">		
		 
		 <s:textfield name="rollNo"  label="Enter Roll No :" />		
		
		<s:textfield name="stuName" label="Enter  Name:" />
		
		<s:textfield name="marks" label="Enter Marks:" />		

		<s:submit name="submit" value="Get U R Result" />
		
	</s:form>

</body>
</html>