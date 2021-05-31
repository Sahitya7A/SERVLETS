package sahitya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstLog extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String n1=request.getParameter("n1");
		String p2=request.getParameter("p1");
		response.setContentType("text/html");
		String s="12345";
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Login</title>");
		out.print("</head>");
		out.print("<body>");
		if(s.equals(p2))
		{
			out.print("<h1>Login Successful</h1>");
			out.print("<h3>Welcome!"+n1+"</h3>");
		}
		else
		{
			out.print("<h1>Login Unsuccessful</h1>");
		}
		out.print("</body>");
		out.print("<html>");
	}

}
