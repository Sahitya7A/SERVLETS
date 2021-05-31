package sahitya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

public class Preview extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        Cookie userData[]=request.getCookies();
				String guestName = userData[0].getValue();				
				String email = request.getParameter("email");
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Preview </title>");
				out.println("</head>");
				out.println("<body>");
				//out.println("<h1>Preview</h1>");
				out.println("<h1>Please confirm your information </h1>");
				out.println("<p>Guest Name : " + guestName + "</p>");
				out.println("<p>Email Id : " + email + "</p>");
				Cookie emailData = new Cookie("email",email);
				response.addCookie(emailData);
				out.println("<form action='Athree' method='post'>");
				out.println("<p><input type='submit' value='Confirm' /> </p></form>");
				out.println("</body>");
				out.println("</html>");
	}

}
