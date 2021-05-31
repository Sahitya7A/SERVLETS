<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=
	pow(5)
%>
<strong> WELCOME </strong>

<%
String name=request.getParameter("uname");
out.println(name);
%>

<%!
	int pow(int num)
	{
	return num*num;
	}
%>
</body>
</html>