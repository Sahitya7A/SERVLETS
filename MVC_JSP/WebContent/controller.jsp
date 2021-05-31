<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "bean_mvc.LoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Controller_</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	
	LoginBean bean = new LoginBean();
	bean.setName(name);
	bean.setPassword(password);
	
	request.setAttribute("bean",bean);
	if(bean.validate())
	{
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
	}
	else
	{
		RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
		rd.forward(request,response);
	}
%>
</body>
</html>