
<!--********************************************************************************
 * File					:RaiseComplaintPage.jsp
 * Author Name			:96121
 * Description			:JSP form to register a customer complaint also contains hyperlink
 						 to CheckStatus.jsp
 * Version				:1.0
 * Create Date			:25-Nov-2016
 *********************************************************************************-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Register Complain Form</title>
	</head>
	<body>
		<h2 align="center">Customer Complaint Request Form</h2>
		<hr>
		<f:form action="addCustomerComplaint.html" method="get" modelAttribute="complaint">
			<table align="center">
				<tr>
				<td>Account Id:*</td>
				<td><f:input path="accountId"/><f:errors path="accountId" cssStyle="color:red"/></td>
				</tr>
				<tr>
				<td>Branch Code:*</td>
				<td><f:input path="branchCode"/><f:errors path="branchCode" cssStyle="color:red"/></td>
				</tr>
				<tr>
				<td>Email Id:*</td>
				<td><f:input path="emailId"/><f:errors path="emailId" cssStyle="color:red"/></td>
				</tr>
				<tr>
				<td>Complaint Category:*</td>
				<td>
					<f:select path="category">
						<f:options items="${categories}"/>
					</f:select><f:errors path="category"/>
				</td>
				</tr>
				<tr>
				<td>Description:*</td>
				<td><f:textarea path="description" rows="4" cols="40"/>
					<f:errors path="description" cssStyle="color:red"/></td>
				</tr>
				<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Submit"/>
				</td>
				</tr>
				<tr>
				<td colspan="2" align="center">
					<a href="checkStatusForm.html">Check Status</a>
				</td>
				</tr>
				
			</table>
		</f:form>
	</body>
</html>