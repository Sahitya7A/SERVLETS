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

public class SaveD extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        Cookie userData[]=request.getCookies();
				String guestName = userData[0].getValue();
				String email = userData[1].getValue();
				PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Save_Data </title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Welcome!!!");
				out.println("<p>Guest Name : " + guestName + "</p>");
				out.println("<p>Email Id : " + email + "</p>");
				out.println("</body>");
				out.println("</html>");
	}

}
