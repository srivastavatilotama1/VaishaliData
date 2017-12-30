<%@page import="com.igate.demo.bean.LanguageBean"%>

<%@page info="test page" %>
<%@ page session="true" %> 
<%@ page isErrorPage="errorPage.jsp" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">

<jsp:useBean id="beanObj"  scope="page" class="com.igate.demo.bean.LanguageBean"> 
	<jsp:setProperty name="beanObj" property="*"/>
	<b>Hello....</b>
	<jsp:getProperty name="beanObj" property="firstname"/>
	</br>
	<b>Your Preffered language Is : </b>
	<jsp:getProperty name="beanObj" property="comment"/>

</jsp:useBean>











</body>
</html>