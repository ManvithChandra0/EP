package com.klef.ep.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.klef.ep.dao.Employee;
import com.klef.ep.dao.EmployeeDAOOperations;

public class InsertEmpServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    // Getting values from FORM
    
    String id = request.getParameter("id");
    Integer eid = Integer.parseInt(id);
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String salary = request.getParameter("salary");
    Double sal = Double.parseDouble(salary);
    String uname = request.getParameter("uname");
    String pwd = request.getParameter("pwd");
    String contactno = request.getParameter("contactno");
    
    Employee emp = new Employee();
    emp.setId(eid);
    emp.setName(name);
    emp.setGender(gender);
    emp.setSalary(sal);
    emp.setUsername(uname);
    emp.setPassword(pwd);
    emp.setContactno(contactno);
    
    
    EmployeeDAOOperations dao = new EmployeeDAOOperations();
    
    int n = dao.insertemployee(emp);
    
    String msg = null;
    
    if(n>0)
    {
      msg = "Employee Registered Successfully";
    }
    else
    {
      msg = "Failed to Register Employee";
    }
    
    request.setAttribute("message", msg);
    
    RequestDispatcher rd = request.getRequestDispatcher("displayresponse.jsp");
    rd.forward(request, response) ;
    
  }
}