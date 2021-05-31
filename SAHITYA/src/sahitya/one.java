package sahitya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/one")
public class one extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String n1=request.getParameter("n1");
		
		response.setContentType("text/html");
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Login</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Login Successful</h1>");
		out.print("<h1>"+n1+"</h1>");
		out.print("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
