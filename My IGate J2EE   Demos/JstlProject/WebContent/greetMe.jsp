<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  bgcolor="pink">
<h3> This is Jstl If tag demo</h3>

<form  action="greetMe.jsp">
	Name:<select name="comboName">
			<option value="SAM">Sam</option>
			<option value="RAM">Ram</option>	
	</select>
	<input type="submit" name="buttonGreet" value="Greet Me"/>
</form>

<b>Welcome :</b>
<c:set var="username" value="${param.comboName}">	
</c:set>
<c:out value="${username}"/>
</br>
<c:if test="${username=='RAM'}">
	<c:out value="Good Morning RAM"/>
</c:if>

<c:if test="${username=='SAM'}">
	<c:out value="How Are U?  SAM"/>
</c:if>
</br> For loop....................
	<c:forEach var="i" begin="1" end="10"  step="2">  
		<c:out value="${i}"/></br>
 </c:forEach>
 <a href="showItemList.jsp">Show Item List</a>
<%!
ArrayList itemList=new ArrayList(); 
%>
<%
	itemList.add("Jeans");
	itemList.add("Skirts");
	itemList.add("Sarees");
	itemList.add("Watch");
	 session.setAttribute("ItemList",itemList);	

%>

<c:set var="item" value="2"/> 
<c:forEach var="item" begin="0" end="0" step="2">
<c:out value="${item}" default="abc"/>
</c:forEach>



</body>

</html>