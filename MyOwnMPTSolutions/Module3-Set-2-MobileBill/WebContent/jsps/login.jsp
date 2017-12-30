<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h3> Enter UR Login Details....</h3>
<c:out value="${requestScope.UserNames}"></c:out>
	<form name="LoginUserForm" action="ProcessUser.do" method="get" 
	 onSubmit="return validation();">
			<table>				
				<tr>
					<td>Usernames :</td>
					<td>
					<select  name="uName" >
						<c:forEach items="${UserNames}" var ="nm">
							<option value='<c:out value="${nm}"></c:out>'><c:out value="${nm}"></c:out></option>
						</c:forEach>
					</select>					
					</td>
				</tr>
				<tr>
				   	<td>Password :</td>
					<td><input type="password" name="pass" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="action" 
					value="ShowBillAmt" ></td>
				</tr>
			</table>
		</form>


</center>
</body>
</html>