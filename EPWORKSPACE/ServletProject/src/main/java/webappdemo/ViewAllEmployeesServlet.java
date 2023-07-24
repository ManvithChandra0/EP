package webappdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Result;

public class ViewAllEmployeesServlet extends HttpServlet
{
  public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    try
    {
      Connection con = null;
        
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        System.out.println("Driver Class Loaded");
            
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets12", "root", "Manvith@123");
        System.out.println("Connection Established");
        
        String qry = "select * from employee";
        
        PreparedStatement pstmt = con.prepareStatement(qry);
        
        ResultSet rs = pstmt.executeQuery();
        
        out.println("<h2 align = 'center'>View All Employees</h2>");
        
        out.println("<table align = center border=2>");
        
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>NAME</th>");
        out.println("<th>GENDER</th>");
        out.println("<th>DOB</th>");
        out.println("<th>SALARY</th>");
        out.println("<th>EMAIL ID</th>");
        out.println("<th>CONTACT NO</th>");
        
        out.println("</tr");
        
        while(rs.next())
        {
          
         out.println("<tr>");
         
         out.println("<td>"+rs.getInt(1)+"</td>");
         out.println("<td>"+rs.getString(2)+"</td>");
         out.println("<td>"+rs.getString(3)+"</td>");
         out.println("<td>"+rs.getString(4)+"</td>");
         out.println("<td>"+rs.getDouble(5)+"</td>");
         out.println("<td>"+rs.getString(6)+"</td>");
         out.println("<td>"+rs.getString(8)+"</td>");
         
         out.println("</tr>");
        }
        
        out.println("</table>");
        
        ResultSet rset = con.createStatement().executeQuery("select count(*) from employee");
        
        int count = 0;
        if(rset.next())
        {
          count = rset.getInt(1);
        }
        
        out.println("<b>Total Employees = </b>"+count);
        con.close();
    }
    catch(Exception e)
    {
      out.println(e);
    }
  }
}