<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="<%=request.getContextPath()%>/images/image004.jpg">
<br>
<br>
<br>
<br>
<br>
<h1 style="color: red" align="center">${error}</h1>
<br>
<br>
<br>
<br>
<br>

<h2 align="center" style="color:purple;"><a href="CricketScoreController?action=fetch">Go to Home page</a></h2>
<br>
<h2 align="center"><a href="CricketScoreController?action=insert">Add New Player</a></h2>



</body>
</html>