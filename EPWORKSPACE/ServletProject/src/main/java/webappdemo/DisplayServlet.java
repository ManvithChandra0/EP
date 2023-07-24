package webappdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    String eid=request.getParameter("id");
    int empid = Integer.parseInt(eid);
    
    String ename=request.getParameter("fname");
    String egender=request.getParameter("gender");
    String edob=request.getParameter("dob");
    
    String esal=request.getParameter("salary");
    double empsal = Double.parseDouble(esal);
    
    String empemail=request.getParameter("emailid");
    String epwd=request.getParameter("pwd");
    String econtact=request.getParameter("contactno");
    
    out.println("<b>GET Request Demo</b></br>");
    
    out.println("EMPLOYEE ID="+empid+"</br>");
    out.println("EMPLOYEE NAME="+ename+"</br>");
    out.println("EMPLOYEE GENDER="+egender+"</br>");
    out.println("EMPLOYEE DOB="+edob+"</br>");
    out.println("EMPLOYEE SALARY="+empsal+"</br>");
    out.println("EMPLOYEE EMAIL ID="+empemail+"</br>");
    out.println("EMPLOYEE PASSWORD="+epwd+"</br>");
    out.println("EMPLOYEE CONTACT NO="+econtact+"</br>");
  }
  
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    String eid=request.getParameter("id");
    int empid = Integer.parseInt(eid);
    
    String ename=request.getParameter("fname");
    String egender=request.getParameter("gender");
    String edob=request.getParameter("dob");
    
    String esal=request.getParameter("salary");
    double empsal = Double.parseDouble(esal);
    
    String empemail=request.getParameter("emailid");
    String epwd=request.getParameter("pwd");
    String econtact=request.getParameter("contactno");
    
    out.println("<b>POST Request Demo</b></br>");
    
    out.println("EMPLOYEE ID="+empid+"</br>");
    out.println("EMPLOYEE NAME="+ename+"</br>");
    out.println("EMPLOYEE GENDER="+egender+"</br>");
    out.println("EMPLOYEE DOB="+edob+"</br>");
    out.println("EMPLOYEE SALARY="+empsal+"</br>");
    out.println("EMPLOYEE EMAIL ID="+empemail+"</br>");
    out.println("EMPLOYEE PASSWORD="+epwd+"</br>");
    out.println("EMPLOYEE CONTACT NO="+econtact+"</br>");
  }
}