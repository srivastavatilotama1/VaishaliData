<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome ${userName}</h2>
<form action="FeedbackController?action=addComment" method="post">
Please select Faculty Name : <select name="facultyName">
<c:forEach items="${facultyNameList}" var="name">
<option value="${name}" >${name }</option>
</c:forEach>
</select>
Please enter feedback comment
<input type="text" name="comment" value="">
<input type="submit" name="btn" value="addComment">

</form>
</body>
</html>