<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String uname=request.getParameter("name");
String upwd =request.getParameter("pwd");
Connection conn =null;
Statement st=null;
try
{
Class.forName("com.mysql.jdbc.Driver");
conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdatabase","root","");
st=conn.createStatement();
String qry="CREATE TABLE login (sno integer,username varchar(32),password varchar(8))";
st.executeUpdate(qry);
out.println("Table completed successfully");
String qry="INSERT INTO `login`(`sno`,`username`,`password`) VALUES (NULL,'"+uname+"','"+upwd"')";
st.executeUpdate(qry);
out.println("Data inserted successfully");
}
catch(Exception ex)
{out.println(ex.getMessage());}
%>
</body>
</html>