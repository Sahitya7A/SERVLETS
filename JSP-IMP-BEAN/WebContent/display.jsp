<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beanpack.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 
	Student st =(Student) request.getAttribute("st1");
	out.println(st.getRollno());
	out.println(st.getName());

%>-->

<jsp:useBean id="st1" class="beanpack.Student" scope="session">
</jsp:useBean>

<jsp:getProperty name="st1" property="rollno" />
<jsp:getProperty name="st1" property="name" />

</body>
</html>
