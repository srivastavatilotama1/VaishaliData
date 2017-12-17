<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Details  here</title>
</head>
<body>

<h1>Application Form</h1>

<c:url var="myAction" value="insertApplication.obj" />
<table>
<form:form method="post" modelAttribute="app" action="${myAction}">
<tr>
  <td> User Name</td>
  <td><form:input path="username"/></td>
  <td><form:errors path="username" cssStyle="color:red"/></td>  
</tr>
<tr>
   <td>Email:</td>
   <td><form:input path="emailId"/></td>
   <td><form:errors path="emailId" cssStyle="color:red"/></td>
</tr>
<tr>
   <td>Mobile:</td>
   <td><form:input path="mobileNumber"/></td>
   <td><form:errors path="mobileNumber" cssStyle="color:red"/></td>
</tr>

<tr>  
<td>Select Your City</td>
<td>
  <form:select path="city"> 
	<form:option value="" label="Please Select"/>
	<form:options items="${cityList}" />
  </form:select>
</td>
<td></td>
</tr>

<tr>
   <td>Application Date:{dd-mm-yyyy} Format</td>
   <td><form:input path="applicationDateText"/></td>
   <td><form:errors path="applicationDateText" cssStyle="color:red"/></td>
</tr>



<tr>
<td>Are You An Existing Account Holder :</td>
   <td>
    <form:radiobutton path="accountExists" value="Y" label="Yes" />
    <form:radiobutton path="accountExists" value="N" label="No" />
   </td>
   <td></td>
</tr>

<tr>
<td>
 <form:checkbox value="No" 
  label="I agree to terms and conditions " path="condition"/>
 </td>
 </tr>

<tr>
  <td colspan="3">
  <input type="submit" value="Apply Credit Card "/>
  </td>
  
   <td colspan="3">
  <input type="reset" value="Clear "/>
  </td>
</tr>
</form:form>
</table>

<a href="list_applications.obj">List All Applications</a></br>
</body>
</html>