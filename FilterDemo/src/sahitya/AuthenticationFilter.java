package sahitya;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class AuthenticationFilter implements Filter {

    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String key=request.getParameter("key");
		String ipAdd=request.getRemoteAddr();
		if(key.equals("Vishu")) {
			System.out.println("User logged in "+ipAdd+" ar "+new Date().toString());
		chain.doFilter(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<h3>Not an Authorized User</h3>");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
