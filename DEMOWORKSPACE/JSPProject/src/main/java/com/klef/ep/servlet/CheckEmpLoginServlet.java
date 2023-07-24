package com.klef.ep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.klef.ep.dao.EmployeeDAOOperations;

public class CheckEmpLoginServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    String uname = request.getParameter("uname");
    String pin = request.getParameter("pin");
    
    EmployeeDAOOperations dao = new EmployeeDAOOperations();
    
    boolean flag = dao.checkemplogin(uname, pin);
    
    String msg = null;
    
    if(flag)
    {
      msg = "Login Success";
    }
    else
    {
      msg = "Login Failed";
    }
    
    request.setAttribute("message", msg);
    
    RequestDispatcher rd = request.getRequestDispatcher("loginresponse.jsp");
    rd.forward(request, response) ;
    
    
    
  }
}