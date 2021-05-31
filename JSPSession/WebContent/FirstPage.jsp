<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FirstPage.jsp</title>
</head>
<body>
<%
	String uname=request.getParameter("name");
	String upass=request.getParameter("password");
	if(uname.equals("KMIT") && upass.equals("NGIT"))
	{
		session.setAttribute("username", uname);
		response.sendRedirect("SecondPage.jsp");
	}
	else
	{
		response.sendRedirect("index.jsp");
	}
	
	
%>
</body>
</html>
