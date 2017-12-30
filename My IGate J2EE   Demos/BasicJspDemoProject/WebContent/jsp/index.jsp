<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.Date"
    session="true" buffer="8kb" autoFlush="true"
  isThreadSafe="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor="pink">
<%@include file="./Header.jsp" %>

<h2>This is Jsp Demo</h2>
<%!
	Date today=new Date(); 
	int count =1;
	
	public int getCount()
	{
		return ++count;		
	}
%>
<%  out.println(" Todays date is :"+today); %>
<h4>********************************</h4>
<%= "Count Is : "+getCount() %>
<a href="./forward.jsp">Go To Forward.jsp Page</a></br>
</br>**************Footer Included Here**************

<jsp:include page="./Footer.jsp"></jsp:include>


</body>
</html>