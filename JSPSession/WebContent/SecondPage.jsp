<%@ page language="java" import="java.util.Date" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SecondPage.jsp</title>
</head>
<body>
<font size=7>Hello</font>
<%= session.getAttribute("username") %>

<%
	long ct=session.getCreationTime();
	Date cd=new Date(ct);
	out.println(cd);
%>
<%=session.getId()%>

<a href="LogOut.jsp">LogOut</a>
</body>
</html>