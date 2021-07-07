package com.kmit.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


public class JDBCServlet extends HttpServlet {
	
	Connection conn=null;
	Statement stmt =null;
	ResultSet rs =null;
	ResultSetMetaData rsmd = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
        String driverName = sc.getInitParameter("driverName"); 
        String driverUrl=sc.getInitParameter("driverUrl"); 
        String username=sc.getInitParameter("username"); 
        String password=sc.getInitParameter("password"); 

		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>JDBC Connection</title>");
		out.println("</head>");
		out.println("<body>");
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(driverUrl, username, password);
			
			out.println("<h3><font color='green'>Connection Successfull</font></h3>");
			
			
			
			
			
			String sql = "select * from login";
			stmt = conn.createStatement();//prepare statment
			rs = stmt.executeQuery(sql);//execute statement
			if(rs!=null) {
				
				rsmd = rs.getMetaData();
				out.println("<p>"+rsmd.getColumnName(1)+"</p>");
				
				//System.out.println(rsmd.getColumnName(1));
				
				while(rs.next()) {
					out.println("<p>"+rs.getInt(1)+" - "+rs.getString(3)+" - "+rs.getString(4)+" </p>");
				}
			}
			else {
				out.println("<h3>No data</h3>");
			}
			
			
			
			
		}catch(Exception e) {
			out.println("<h3><font color='red'>Connection Failed</font></h3>");
			out.println("<p>"+e.getMessage()+"</p>");
		}
		finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				out.println("<p>"+e.getMessage()+"</p>");
				e.printStackTrace();
			}
		}
		
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
