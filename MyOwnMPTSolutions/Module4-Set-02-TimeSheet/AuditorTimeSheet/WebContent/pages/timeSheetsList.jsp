<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<link href="styles/mystyle.css" rel="stylesheet"/>
	</head>
	<body>
		<h1>BlueBrains Auditing Services Internal Portal - TimeSheets List</h1>
		
		
		<form action="listTimeSheets.obj">
			<div class="center">
			<label>Enter Employee Id:
				<input type="text" name="empId" pattern="[A-Z]{3}[0-9]{5}" />
			</label>
			<button type="submit">
				Fetech
			</button>
			</div>
		</form>

		<c:if test="${timeSheets ne null }">
			<c:choose>
				<c:when test="${timeSheets.size() != 0 }">
					<table>
						<tr><th>EmpId</th>
							<th>Date</th>
							<th>1<sup>st</sup>Hour</th>
							<th>2<sup>nd</sup>Hour</th>
							<th>3<sup>rd</sup>Hour</th>
							<th>4<sup>th</sup>Hour</th>
							<th>5<sup>th</sup>Hour</th>
							<th>6<sup>th</sup>Hour</th>
							<th>7<sup>th</sup>Hour</th>
							<th>8<sup>th</sup>Hour</th>
						</tr>
					<c:forEach items="${timeSheets }" var="ts">
						<tr>
						<td>${ts.empId }</td>
						<td>${ts.timeSheetDate }</td>
						<td>${ts.firstHourAction }</td>
						<td>${ts.secondHourAction }</td>
						<td>${ts.thirdHourAction }</td>
						<td>${ts.fourthHourAction }</td>
						<td>${ts.fifthHourAction }</td>
						<td>${ts.sixthHourAction }</td>
						<td>${ts.seventhHourAction }</td>
						<td>${ts.eighthHourAction }</td>
						</tr>
					</c:forEach>	
					</table>
					
				</c:when>
				<c:otherwise>
					<p class="info">
						No time sheets recorded!
					</p>
				</c:otherwise>
			</c:choose>			
		</c:if>

		<a href="showHomePage.obj">Home</a> <br />				
	</body>
</html>