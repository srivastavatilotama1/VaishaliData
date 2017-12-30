<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false"
      errorPage="./DivisionError.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="Pink">
<% 
		int num1,num2,result; %>


<% 
    num1=Integer.parseInt(request.getParameter("txtNum1"));
	num2=Integer.parseInt(request.getParameter("txtNum2"));
	
	result=num1/num2;
	out.println(" <b>Division Of Number Is :</b> "+result);


%>

</body>
</html>