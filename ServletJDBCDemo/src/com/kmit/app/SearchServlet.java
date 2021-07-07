package com.kmit.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CallableStatement call = null;
	Connection conn=null;
	ResultSet rs = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		
		ServletContext sc = getServletContext();
        String driverName = sc.getInitParameter("driverName"); 
        String driverUrl=sc.getInitParameter("driverUrl"); 
        String username=sc.getInitParameter("username"); 
        String password=sc.getInitParameter("password"); 
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>JDBC Connection</title>");
		out.println("</head>");
		out.println("<body>");
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(driverUrl, username, password);
			//logic
			
			String sql = "{call getUserDetails(?)}";
			call = conn.prepareCall(sql);//prepare
			call.setInt(1, id);//mapping
			
			rs = call.executeQuery();//execute
			
			if(rs!=null) {

				while(rs.next()) {
					out.println("<p>"+rs.getInt(1)+" - "+rs.getString(3)+" - "+rs.getString(4)+" </p>");
				}
			}
			else {
				out.println("<p>No Data</p>");
			}
		
			
			
		}catch(Exception e) {
			
			out.println("<p>"+e.getMessage()+"</p>");
		}
		finally {
			try {
				
				conn.close();
			} catch (SQLException e) {
				out.println("<p>"+e.getMessage()+"</p>");
				e.printStackTrace();
			}
		}
		
		out.println("</body>");
		out.println("</html>");
		
	}

}
