package sahitya;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/registration.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String confirm_pass=request.getParameter("confirm_password");
		
		ServletContext sc=getServletContext();
		String driverName=sc.getInitParameter("driverName");
		String driverUrl=sc.getInitParameter("driverUrl");
		String username=sc.getInitParameter("username");
		String password=sc.getInitParameter("pasword");
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try
		{
			Class.forName(driverName);
			conn=DriverManager.getConnection(driverUrl,username,password);
			System.out.println("Connection successful");
			
			String sql="select * from login where username=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				//dtaa is there
				request.setAttribute("error", "user already exists");
				
				request.getRequestDispatcher("ErrorServlet").forward(request, response);
			}
			else {
				//inser ope
				String insertSQL="insert into login(username,fullname,email,password),values(?,?,?,?);";
				pstmt=conn.prepareStatement(insertSQL);
				pstmt.setString(1, name);
				pstmt.setString(2, fullname);
				pstmt.setString(3, email);
				pstmt.setString(4, pass);
				
				int i=pstmt.executeUpdate();
				if(i==1) {
					//login servlet
					response.sendRedirect("LoginServlet");
				}
				else {
					request.setAttribute("error","Not able to register");

					request.getRequestDispatcher("ErrorServlet").forward(request, response);
									}
				
			}
			
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Failed");
			request.setAttribute("error","Not able to register"+ e.getMessage());
			request.getRequestDispatcher("ErrorServlet").forward(request, response);
		}
		finally
		{
			try {
				pstmt.close();
				rs.close();
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				request.setAttribute("error","Not able to register"+ e.getMessage());
				request.getRequestDispatcher("ErrorServlet").forward(request, response);
			}
		}
	}
MINE@@
}*/
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String confirm_pass = request.getParameter("confirm_password");
		
		ServletContext sc = getServletContext();
		String driverName=sc.getInitParameter("driverName"); 
		String driverUrl=sc.getInitParameter("driverUrl"); 
		String username=sc.getInitParameter("username"); 
		String password=sc.getInitParameter("password");
		
		 Connection conn=null;
		 PreparedStatement pstmt =null;
		 ResultSet rs = null;
		
		try {
			//connection
			Class.forName(driverName);
			conn = DriverManager.getConnection(driverUrl, username, password);
			System.out.println("Connection established");
			
			String sql = "select * from login where username= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				//data is present
				request.setAttribute("error", "User already exist");
				request.getRequestDispatcher("ErrorServlet").forward(request, response);
			}
			else {
				//insert operation
				String insertSQL = "insert into  login (username,fullname,email, password)  values (?,?,?,?);";
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, name);
				pstmt.setString(2, fullname);
				pstmt.setString(3, email);
				pstmt.setString(4, pass);
				
				int i = pstmt.executeUpdate();
				if(i==1) {
					//login servlet
					response.sendRedirect("LoginServlet");
				}
				else {
					request.setAttribute("error","Not able to Register" );
					request.getRequestDispatcher("ErrorServlet").forward(request, response);
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection failed");
			request.setAttribute("error","Not able to Register " + e.getMessage() );
			request.getRequestDispatcher("ErrorServlet").forward(request, response);
		}
		finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error","Not able to Register " + e.getMessage() );
				request.getRequestDispatcher("ErrorServlet").forward(request, response);
			}
		
		}
	}

}
