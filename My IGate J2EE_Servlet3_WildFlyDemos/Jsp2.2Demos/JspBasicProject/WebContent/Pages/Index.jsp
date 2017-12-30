
<%@ page language="java" 
contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.time.LocalDate"    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include  file="/Html/Header.html" %>
	<h1> This is printed By Index page heading tag</h1>
	<%= "Welcome To IGate" %>
	<hr/>
	<%
		for(int i=0;i<5;i++)
		{
			out.println(" I = "+i+"</br>");
		}		
	%>
	<%=" Today Is : "+LocalDate.now() %>
	<hr/>
	<jsp:include page="/Pages/Footer.jsp"></jsp:include>
</body>
</html>