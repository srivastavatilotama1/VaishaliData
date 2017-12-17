<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insert  Successfully!!!!</h1>

<h2>Application  Info</h2>
Application Id : ${app.applicationId}<br/>
User Name : ${app.username}<br/>
EMail  : ${app.emailId}<br/>
Mobile No : ${app.mobileNumber}<br/>
City : ${app.city}<br/>
Application  Date: ${app.appliedDate}<br/>
Account Exists ?  : ${app.accountExists}<br/>


</body>
</html>