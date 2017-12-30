<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<link href="styles/mystyle.css" rel="stylesheet"/>
		<title>Time Sheet Entry</title>
	</head>
	<body>
		<h1>BlueBrains Auditing Services Internal Portal - TimeSheet Entry</h1>
		<form:form action="addTimeSheet.obj" modelAttribute="timeSheet">
			<table>
				<tr><td>Employee Id:</td>
					<td><form:input path="empId"/> 
					<br /><form:errors path="empId"/>
					</td>
				</tr>
				<tr><td>Time Sheet Date:</td>
					<td><form:input path="timeSheetDate" type="date"/> 
					<br /><form:errors path="timeSheetDate"/>
					</td>
				</tr>
				<tr><td>First Hour Activity:</td>
					<td><form:select path="firstHourAction" >
							<form:option value="">---SELECT---</form:option>
							<form:options items="${workActions }"/>
						</form:select> 
					<br /><form:errors path="firstHourAction"/>
					</td>
				</tr>
				<tr><td>Second Hour Activity:</td>
					<td><form:select path="secondHourAction" >
							<form:option value="">---SELECT---</form:option>
							<form:options items="${workActions }"/>
						</form:select> 
					<br /><form:errors path="secondHourAction"/>
					</td>
				</tr>
				<tr><td>Third Hour Activity:</td>
					<td><form:select path="thirdHourAction" >
							<form:option value="">---SELECT---</form:option>
							<form:options items="${workActions }"/>
						</form:select> 
					<br /><form:errors path="thirdHourAction"/>
					</td>
				</tr>
				<tr><td>Fourth Hour Activity:</td>
					<td><form:select path="fourthHourAction" >
							<form:option value="">---SELECT---</form:option>
							<form:options items="${workActions }"/>
						</form:select> 
					<br /><form:errors path="fourthHourAction"/>
					</td>
				</tr>
				<tr><td>Fifth Hour Activity:</td>
					<td><form:select path="fifthHourAction" >
							<form:option value="">---SELECT---</form:option>
							<form:options items="${workActions }"/>
						</form:select> 
					<br /><form:errors path="fifthHourAction"/>
					</td>
				</tr>
				<tr><td>Sixth Hour Activity:</td>
					<td><form:select path="sixthHourAction" >
							<form:option value="">---SELECT---</form:option>
							<form:options items="${workActions }"/>
						</form:select> 
					<br /><form:errors path="sixthHourAction"/>
					</td>
				</tr>
				<tr><td>Seventh Hour Activity:</td>
					<td><form:select path="seventhHourAction" >
							<form:option value="">---SELECT---</form:option>
							<form:options items="${workActions }"/>
						</form:select> 
					<br /><form:errors path="seventhHourAction"/>
					</td>
				</tr>
				<tr><td>Eigth Hour Activity:</td>
					<td><form:select path="eighthHourAction" >
							<form:option value="">---SELECT---</form:option>
							<form:options items="${workActions }"/>
						</form:select> 
					<br /><form:errors path="eighthHourAction"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="right">
						<button type="submit">Save</button>
					</td>
				</tr>
			</table>
		</form:form>
		<a href="showHomePage.obj">Home</a> <br />		
	</body>
</html>