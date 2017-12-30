<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="fo" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table bgcolor="pink">
<fo:form method="post" action="update" modelAttribute="my">
<tr style="visibility:hidden;">
<td>ID</td>
<td><fo:input path="tId" value="${my.tId}" /></td>
</tr>
<tr>
<td>Session Name</td>
<td><fo:input path="tName" value="${my.tName}" readonly="true"/></td>
<td><fo:errors path="tName"></fo:errors></td>
</tr>
<tr>
<td>Duration</td>
<td><fo:input path="tDuration" value="${my.tDuration}"/></td>
<td><fo:errors path="tDuration"></fo:errors></td>
</tr>
<tr>
<td>Faculty</td>
<td><fo:input path="tFaculty" value="${my.tFaculty}"/></td>
<td><fo:errors path="tFaculty"></fo:errors></td>
</tr>

<tr>
<td>Mode</td>
<td><fo:select path="tMode" items="${mydep}"></fo:select></td>
</tr>
<tr>
<td><input type="submit" value="update"></td>
</tr>
</fo:form>
</table>
</body>
</html>