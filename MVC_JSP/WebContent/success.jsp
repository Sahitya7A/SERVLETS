<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean_mvc.LoginBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Successful Login</title>
</head>
<body>
<h1>Logged in successfully</h1>
<%
	LoginBean bean =(LoginBean)request.getAttribute("bean");
	//out.println(bean.getName());
	String uname = bean.getName();
	String passc = bean.getPassword();
	out.println("<h2>Welcome</h2>"+uname);
%>
</body>
</html>