<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<h3> Enter Your Login Details.....</h3>
<form action="IGateController.do?action=ValidateLogin" 
method="Post">
	UserName:
	<select name="listUserName">
	<c:forEach var="unm" items="${UserNameList}">
			<option value='<c:out value="${unm}"/>'>
					<c:out value="${unm}"/> 
			</option>
	</c:forEach>
	
	</select>
	</br>
	Password:<input type="password" name ="txtPwd" value=""/></br>
	<input type="submit" name="buttonLogin" value="LOGIN"/>
</form>

<h2>[${Message}]</h2>

</body>
</html>