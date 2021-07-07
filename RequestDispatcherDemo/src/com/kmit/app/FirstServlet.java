package com.kmit.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>First Servlet </title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Hello First Servlet Post</h1>");
		out.print("</body>");
		out.print("</html>");
		
		//request.getRequestDispatcher("SecondServlet").include(request, response);
		response.sendRedirect("SecondServlet");
	}

}
