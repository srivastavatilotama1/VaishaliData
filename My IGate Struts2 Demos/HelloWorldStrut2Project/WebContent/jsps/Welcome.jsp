<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags"  prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details Page</title>
</head>
<body bgcolor="cyan">

<s:property value="getText('global.success')" /><br/>

    User Name: <s:property value="userName" /><br>
    First Name: <s:property value="firstName" /><br>
    Last Name: <s:property value="lastName" /><br>
    Gender: <s:property value="gender" /><br>
    Country: <s:property value="country" /><br>
    About You: <s:property value="about" /><br>
    Community: <s:property value="community" /><br>
     Hobbies: <s:property value="hobbies" /><br>
    Mailing List: <s:property value="mailingList" /><br>
   Age: <s:property value="age" /><br>
   Date Of Birth: <s:property value="dob" /><br>
   
   <h4>************Data Tags********************</h4>
   <s:set name="myAge" value="%{23}"/>   
   <h3>The Age  U Have Assigned  is :</h3>
   <s:property value="#myAge "/>
   
    <h4>********************************</h4>
   <s:set name="myAge2" value="age" scope="application"/>   
   <s:property value="#application['myAge2'] "/>
   
    <h4>*********Senior Or Junier***********************</h4>
  
  <s:set name="tempAge" value="age"/>  
   <s:if test="%{#tempAge<=40}">  
  				<h2>Junier</h2>	
 	</s:if>
 	<s:else>  
  			 <h2>Senior</h2>
	 </s:else> 
		
</body>
</html>