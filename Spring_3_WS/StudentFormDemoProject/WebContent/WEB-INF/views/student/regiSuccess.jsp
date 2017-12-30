 <%@ page session="false"%>
 <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<head>
		<title>Student Details Display</title>
	</head>
	<body>
		<center>
			<h3>Student Details Display</h3><br>
			<table>
						<tr>
	     					<td colspan="2" align="center"><font size="5">Student Information</font></td>	     						     					
	     				</tr>
	     				<tr>
	     					<td>Name:</td>
	     					<td><core:out value="${stu.name}"/></td>	     					
	     				</tr>
	     				
	     					     				
	            	</table>
			<a href="user.html">Back</a>
		</center>
	</body>
</html>
