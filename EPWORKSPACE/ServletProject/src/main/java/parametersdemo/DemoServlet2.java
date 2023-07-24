package parametersdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet2 extends HttpServlet {

  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<b>I am in Demo Servlet 2</b></br>");
    
        out.println("<b>Init Parameters Demo</b></br>");
    
    ServletConfig config = getServletConfig();
    out.println("Gender= "+config.getInitParameter("gender"));
    out.println("Password= "+config.getInitParameter("password"));
    
    out.println("</br>");
    out.println("<b>Context Parameters Demo</b></br>");
    
    ServletContext context = getServletContext();
    out.println("Department= "+context.getInitParameter("department"));
    out.println("Course= "+context.getInitParameter("course"));
  }
}