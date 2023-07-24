package lifecycle;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class ThirdServlet implements Servlet
{
	ServletConfig config = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method invoked");
		this.config=config;
		System.out.println("Servlet Name:"+config.getServletName());
		
	}
	@Override
	public ServletConfig getServletConfig() {
		
		return this.config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service method invoked");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<b>Lifecycle Demo</b>");
		
	}


	@Override
	public String getServletInfo() {
		return "KLU Author - Servlet Life Cycle Demo V1.0";
	}
	
	@Override
	public void destroy() {
		System.out.println("destory method invoked");
		
	}





	
}