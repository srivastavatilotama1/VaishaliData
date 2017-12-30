<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="stu" class="com.igate.bean.Student" scope="page">
	<jsp:setProperty name="stu" property="*" />
	
</jsp:useBean>
<b>Hello : </b> <jsp:getProperty property="stuName" 
		name="stu"/><br/>		
<b> Your Marks </b><jsp:getProperty property="marks" 
		name="stu"/><br/>
<b> Your Result Is  :

<input type='text' name='txtGrade'
 value='<jsp:getProperty name="stu"
  property="grade"></jsp:getProperty>'/>
 
</body>
</html>