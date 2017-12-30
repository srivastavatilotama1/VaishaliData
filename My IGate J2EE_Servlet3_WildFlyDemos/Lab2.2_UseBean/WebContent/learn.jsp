<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learn Page</title>
</head>
<frameset rows="20%,80%">
	<frame src="top.jsp" scrolling="no" noresize="noresize">
		<frameset cols="30%,70%"> 
				<frame src="left.jsp" noresize="noresize" scrolling="no">
				<frame src="right.jsp" noresize="noresize" scrolling="no" name="display">
		</frameset>
</frameset>
</html>