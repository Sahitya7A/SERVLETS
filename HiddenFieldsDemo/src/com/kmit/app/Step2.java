package com.kmit.app;

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
		String guestName = request.getParameter("guestName");
		
		//Cookie guestData = new Cookie("guestName",guestName);
		//response.addCookie(guestData);
		
		HttpSession session = request.getSession();
		session.setAttribute("guestName", guestName);
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Step2 </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Welcome " + guestName + "</h3>");
		//form -> action="Preview"
		out.println("<form action='Preview' method='post'>");
		out.println("<p>Enter Email Id : </p>");
		out.println("<p><input type='email' name='email' /> </p>");
		//out.println("<p><input type='hidden' name='guestName' value='"+guestName+"' /> </p>");
		out.println("<p><input type='submit' value='Preview' /> </p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
