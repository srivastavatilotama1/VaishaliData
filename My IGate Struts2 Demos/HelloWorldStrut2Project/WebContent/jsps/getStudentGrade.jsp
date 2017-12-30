<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Student Details are<br>
Roll no :<s:property value= "rollNo" /><br/>
Name :<s:property value= "stuName" /><br/>
marks :<s:property value= "marks" /><br/>
Grade  :<s:property value= "grade" /><br/>

<hr color="Green" size="2" width="100" ></hr>

<s:bean name="com.igate.dto.Student">
	<s:param name="marks" value="89" />
	Grade Is  = <s:property value="grade" /> 
</s:bean>

</body>
</html>