package com.kmit.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
	PreparedStatement pstmt =null;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
        String driverName = sc.getInitParameter("driverName"); 
        String driverUrl=sc.getInitParameter("driverUrl"); 
        String username=sc.getInitParameter("username"); 
        String password=sc.getInitParameter("password"); 
		
		String uname= request.getParameter("username");
		String pass = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		
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
			
			String sql = "insert into  login (username,fullname,email, password)  values (?,?,?,?);";
			pstmt = conn.prepareStatement(sql);//prepare
			pstmt.setString(1, uname);
			pstmt.setString(2, fullname);
			pstmt.setString(3, email);
			pstmt.setString(4, pass); //mapped data
			
			int i = pstmt.executeUpdate();
			
			if(i==1) {
				out.println("<h1>Added</h1>");
				out.println("<h3><a href='JDBCServlet'>View Data</a></h3>");
			}
			else 
				out.println("<h1>Error in Adding</h1>");
			
			
		}catch(Exception e) {
			
			out.println("<p>"+e.getMessage()+"</p>");
		}
		finally {
			try {
				pstmt.close();
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
