package sahitya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Step2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guestName=request.getParameter("guest");
		HttpSession session = request.getSession();
		session.setAttribute("guestName", guestName);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Step2 </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Welcome " + guestName + "</h1>");
		out.println("<form action='Atwo' method='post'>");
		out.println("<p>Enter Email Id : </p>");
		out.println("<p><input type='email' name='email' /> </p>");
		out.println("<p><input type='submit' value='Preview' /> </p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
