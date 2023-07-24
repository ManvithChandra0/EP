package lifecycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondServlet extends GenericServlet{
  public void init() {
    System.out.println("init method is invoked");
  }
  public void service(ServletRequest request, ServletResponse response) throws IOException,ServletException {
    System.out.println("service method is invoked");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<b>Lifecycle Demo</b>");
  }
  public void destroy() {
    System.out.println("destroy method is invoked");
  }
}