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
    Student st = new Student();
    st.setRollno(Integer.parseInt(request.getParameter("roll")));
    st.setName(request.getParameter("uname"));
    
    request.setAttribute("st1", st);
    RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
    rd.forward(request,response);
%> -->


<jsp:useBean id="st1" class="beanpack.Student" scope="session">
</jsp:useBean>
<jsp:setProperty property="rollno" name="st1" value='<%=Integer.parseInt(request.getParameter("roll")) %>'/>
<jsp:setProperty property="name" name="st1" value='<%=request.getParameter("uname") %>'/>

<%
RequestDispatcher rd= request.getRequestDispatcher("display.jsp");
rd.forward(request,response);
%>
</body>
</html>