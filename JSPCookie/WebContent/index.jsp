<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Cookie Management</title>
</head>
<body>
<%
	Cookie cks= new Cookie("jsp_cookie","Sahitya");
	cks.setMaxAge(10);
	response.addCookie(cks);
	out.println("Cokkie Submited Successfully");	
%>
<a href="check.jsp">Check Cookie</a>
</body>
</html>