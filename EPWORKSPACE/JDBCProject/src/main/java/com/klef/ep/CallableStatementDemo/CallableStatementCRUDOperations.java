package com.klef.ep.CallableStatementDemo;

import java.sql.*;
import java.util.*;

public class CallableStatementCRUDOperations {

	public static void main(String[] args) {

		CallableStatementCRUDOperations crud = new CallableStatementCRUDOperations();
		//crud.addfaculty();
		//crud.updatefaculty();
		//crud.deletefaculty();
		//crud.viewallfaculty();
		crud.getfacultynamebyid();
	}
	public void addfaculty()
	{
		try 
    	{
    		Connection con = null;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12","root","Manvith@123");
    		System.out.println("Connection Established");
    		
    		int fid=3;
    		String fname="abhi";
    		String fgender="MALE";
    		CallableStatement cstmt = con.prepareCall(" {call insertfaculty(?,?,?)} ");
    		
    		cstmt.setInt(1, fid);
    		cstmt.setString(2, fname);
    		cstmt.setString(3, fgender);
    		int n =cstmt.executeUpdate();
     		System.out.println(n+"Record(s) Inserted");
    		con.close();
    		}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
	}
	public void updatefaculty() {
	    try {
	        Connection con = null;
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        System.out.println("Driver Class Loaded");

	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12", "root", "Manvith@123");
	        System.out.println("Connection Established");

	        int fid = 3;
	        String fname = "ram";

	        CallableStatement cstmt = con.prepareCall("{call updatefaculty(?,?,?)}");

	        cstmt.setInt(1, fid);
	        cstmt.setString(2, fname);
	        cstmt.setNull(3, java.sql.Types.NULL);

	        int n = cstmt.executeUpdate();

	        System.out.println(n + " Record(s) updated successfully");

	        con.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	public void deletefaculty() {
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
	        
	        CallableStatement cstmt = con.prepareCall("{call deletefaculty(?)}");
	        cstmt.setInt(1, eid);
	        
	        int n = cstmt.executeUpdate();
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
	public void viewallfaculty()
	{
		try 
    	{
    		Connection con = null;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12","root","Manvith@123");
    		System.out.println("Connection Established");
    		
	        CallableStatement cstmt = con.prepareCall("{call viewallfaculty()}");
    		ResultSet rs =cstmt.executeQuery();
    		System.out.println("****Faculty Information****");
    		System.out.println();

    		while(rs.next())
    		{
        		System.out.println("Faculty Record "+rs.getRow());
    			System.out.println("Faculty id "+rs.getInt(1)); // id
        		System.out.println("Faculty name "+rs.getString(2)); // name
        		System.out.println("Faculty gender "+rs.getString(3)); // gender
        		System.out.println();
    		}
    		con.close();
    	}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
	}
	public void getfacultynamebyid()
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
	        CallableStatement cstmt = con.prepareCall("{call getfacultynamebyid(?,?)}");
	        cstmt.setInt(1, eid);
	        cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
	        cstmt.execute();
    		System.out.println(cstmt.getString("fname"));
    		con.close();
    	}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
	}


}
