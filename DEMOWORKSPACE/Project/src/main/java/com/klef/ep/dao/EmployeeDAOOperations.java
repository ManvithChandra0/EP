package com.klef.ep.dao;

import java.sql.*;

public class EmployeeDAOOperations 
{
  
  public boolean checkemplogin(String uname,String pin)
  {
	boolean flag = false;
    try
    {
      Connection conn = DBConnection.getConnection(); 
      
      PreparedStatement ps = conn.prepareStatement("select * from Credentials where username=? and pin=?");
      
      ps.setString(1, uname);
      ps.setString(2, pin);
      
      ResultSet rs =  ps.executeQuery();
      
      if(rs.next())
      {
    	  flag=true;
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    return flag;
  }
}