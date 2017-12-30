<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   
    import="com.igate.util.DbUtil,java.sql.*"
    
    session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String un=request.getParameter("txtUName");
String pw=request.getParameter("txtPassword");
Connection con=DbUtil.getConnection();
System.out.println(" Connnnnnn*********"+con);
String sql="SELECT * from MyUser Where  UName=?";
PreparedStatement pst=con.prepareStatement(sql);
pst.setString(1,un);
ResultSet rs=pst.executeQuery();
boolean present=false;
rs.next();
	if(un.equalsIgnoreCase(rs.getString("UName"))&&
	(pw.equalsIgnoreCase(rs.getString("password"))))
	{
		session.setAttribute("UserName", un);
%>
<jsp:forward page="/Pages/EmployeeOperation.jsp"></jsp:forward>
<%		
	}
	else
	{
		out.println(" User is In Valid User");
	}


%>
</body>
</html>