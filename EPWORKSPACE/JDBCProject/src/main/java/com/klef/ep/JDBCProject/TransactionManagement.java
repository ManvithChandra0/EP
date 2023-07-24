package com.klef.ep.JDBCProject;

import java.sql.*;

public class TransactionManagement 
{
  public static void main(String[] args) 
  {
    try
    {
      Connection con = null;
      
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Driver Class Loaded");
      
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12", "root", "Manvith@123");
      System.out.println("Connection Established");
      
      con.setAutoCommit(false); // TRUE BY DEFAULT
      
//      con.createStatement().executeUpdate(" insert into faculty values(501,'ABC','MALE')");
//      
//      con.createStatement().executeUpdate(" insert into faculty values(502,'XYZ','FEMALE')");
//      con.createStatement().executeUpdate(" insert into faculty values(503,'PQR','MALE')");

      Savepoint s1 = con.setSavepoint("s1");
      
      con.createStatement().executeUpdate(" delete from faculty where id = 503");
      
      Savepoint s2 = con.setSavepoint("s2");
      
      con.rollback(s2);
      
      con.commit();
      
      con.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }

}