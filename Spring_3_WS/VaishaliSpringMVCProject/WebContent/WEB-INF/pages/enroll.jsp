<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	<form:form action="saveStudent.obj" method="post" commandName="stud">
		<table border="1">
			<tr>
				<td>RollNo:</td>
				<td><form:input path="roll" />
				</td>
				<td style="color: red"><form:errors path="roll"></form:errors>
				</td>
			</tr>

			<tr>
				<td>Name:</td>
				<td><form:input path="name" />
				</td>
				<td style="color: red"><form:errors path="name"></form:errors>
				</td>
			</tr>

			<tr>
				<td>Enroll Date:</td>
				<td><form:input path="enrollDate" />
				</td>
				<td style="color: red"><form:errors path="enrollDate"></form:errors>
				</td>
			</tr>

			<tr>

				<td><input type="submit" value="Entroll" />
				</td>

			</tr>			
		</table>
		</form:form>
</body>
</html>