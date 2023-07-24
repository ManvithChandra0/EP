package com.klef.ep.PreparedStatementDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementCRUDOperations {

	public static void main(String[] args) 
	{
		PreparedStatementCRUDOperations crud = new PreparedStatementCRUDOperations();
		//crud.addemployee();
		//crud.updateemployee();
		//crud.deleteemployee();
		//crud.viewallemp();
		crud.viewemployeebyid();
	}
	public void addemployee()
	{
		try 
    	{
    		Connection con = null;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12","root","Manvith@123");
    		System.out.println("Connection Established");
    		int sid=103;
    		String ename="chandra";
    		String egender="MALE";
    		String edob="01/06/2003";
    		double esal=78000.50;
    		String empemail="chandra@gmail.com";
    		String epwd="chandra";
    		String econtact="232323232";
    		
    		PreparedStatement pstmt = con.prepareStatement(" insert into employee values(?,?,?,?,?,?,?,?) ");
    		pstmt.setInt(1, sid);
    		pstmt.setString(2, ename);
    		pstmt.setString(3, egender);
    		pstmt.setString(4, edob);
    		pstmt.setDouble(5, esal);
    		pstmt.setString(6, empemail);
    		pstmt.setString(7, epwd);
    		pstmt.setString(8, econtact);

    		 int n =pstmt.executeUpdate();
     		System.out.println(n+"Record(s) Inserted");
    		con.close();
    		}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
	}
	public void updateemployee()
	{
		 try
		    {
		      Connection con = null;
		      
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      System.out.println("Driver Class Loaded");
		      
		      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12", "root", "Manvith@123");
		      System.out.println("Connection Established");
		      
		      int eid = 103;
		      String ename = "chandra";
		      double esal = 50000.90;

		      PreparedStatement pstmt = con.prepareStatement(" update employee set name = ?,salary = ? where id = ? ");
		      pstmt.setString(1, ename);
		      pstmt.setDouble(2, esal);
		      pstmt.setInt(3, eid);
		      
		      
		      int n = pstmt.executeUpdate();
		      
		      System.out.println(n+" Record(s) Updated");
		      
		      con.close();
		    }
		    catch(Exception e)
		    {
		      System.out.println(e);
		    }
	}
	public void deleteemployee() {
	     try
	     {
	        Connection con = null;
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        System.out.println("Driver class loaded");
	        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12", "root", "Manvith@123");
	        System.out.println("Connection Established");    
	        
	        Scanner sc = new Scanner(System.in);
	        System.out.println("enter emp id=");
	        int eid = sc.nextInt();
	        
	        PreparedStatement pstmt = con.prepareStatement("delete from employee where id=? ");
	        pstmt.setInt(1, eid);
	        
	        int n = pstmt.executeUpdate();
	        if(n>0)
	        {
	          System.out.println("Record Deleted sucessfully");
	        }
	        else
	        {
	          System.out.println("Employee Id not found");
	        }
	        
	        con.close();
	     }
	     catch(Exception e)
	     {
	       System.out.println(e);
	     }
	   }
	public void viewallemp()
	{
		try 
    	{
    		Connection con = null;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12","root","Manvith@123");
    		System.out.println("Connection Established");
    		
	        PreparedStatement pstmt = con.prepareStatement("select * from employee ");
    		ResultSet rs =pstmt.executeQuery();
    		System.out.println("****Employee Information****");
    		System.out.println();

    		while(rs.next())
    		{
        		System.out.println("Employee Record "+rs.getRow());
    			System.out.println(rs.getInt(1)); // id
        		System.out.println(rs.getString(2)); // name
        		System.out.println(rs.getDouble(5)); // salary
        		System.out.println(rs.getString(8)); // contact number
        		System.out.println(rs.getString("email")); // gender
        		System.out.println();
    		}
    		con.close();
    	}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
	}
	public void viewemployeebyid()
	{
		try 
    	{
    		Connection con = null;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12","root","Manvith@123");
    		System.out.println("Connection Established");
    		  Scanner sc = new Scanner(System.in);
  	        System.out.println("enter emp id=");
  	        int eid = sc.nextInt();
	        PreparedStatement pstmt = con.prepareStatement("select id,name,email from employee where id=? ");
	        pstmt.setInt(1, eid);
    		ResultSet rs =pstmt.executeQuery();
    		if(rs.next()) 
    		{
    			System.out.println(rs.getInt("id")); // id
    			System.out.println(rs.getString("name")); // name
        		System.out.println(rs.getString("email")); // email
    		}
    		con.close();
    	}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
	}
	
}
