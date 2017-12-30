<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="view/style.css"/>
<title>SUCCESS</title>
</head>
<body background="<%=request.getContextPath()%>/images/image003.jpg">
<div>
<h1 style="color: green" align="center"> Player Data Saved Successfully </h1>
</div>
<br>
<br>
<h2 style="color: red"><a href="CricketScoreController?action=fetch"><span style="color: blue">Click here to view all the score records.</span></a></h2>
<br>
<h2 style="color: red"><a href="CricketScoreController?action=insert"><span style="color: blue">Add new Player</span></a></h2>
</body>
</html>