<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
    
  <%

   String emailid  = request.getParameter("email");
   String pwd = request.getParameter("pwd");
   
   try
   {
        Connection con = null;
       
       Class.forName("com.mysql.cj.jdbc.Driver"); 
       System.out.println("Driver Class Loaded");
           
       con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsps12", "root", "Manvith@123");
       System.out.println("Connection Established");
       
       PreparedStatement pstmt = con.prepareStatement(" select * from user where email=? and password=?");
       pstmt.setString(1, emailid);
       pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
		{
			session.setAttribute("email", emailid); //email,name is session variable
			String name=rs.getString("name");
			session.setAttribute("name", name);
			response.sendRedirect("userhome.jsp");
		}
		else
		{
			out.println("Login Failed");
		}
       
       
   }
   catch(Exception e)
   {
     out.println(e);
   }
  
  
  
  %>