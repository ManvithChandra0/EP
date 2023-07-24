package com.klef.ep.StatementDemo;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;

public class StatementCRUDOperations {

	public static void main(String[] args) 
	{
		StatementCRUDOperations crud = new StatementCRUDOperations();
        //crud.insertstudent();
		//crud.updatestudent();
		//crud.deletestudent();
		crud.viewallstudents();
	}
	public void insertstudent()
	{
		try 
    	{
    		Connection con = null;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12","root","Manvith@123");
    		System.out.println("Connection Established");
    		Statement stmt = null;
    		stmt=con.createStatement();
    		
    		int sid=104;
    		String sname="humesh";
    		String sgender="Male";
    		double scgpa=6.78;
    		int sbacklogs=1;
    		String semail="humesh@gmail.com";
    		String scontact="213211298";
    		
    		String qry = "insert into student values("+sid+",'"+sname+"','"+sgender+"',"+scgpa+","+sbacklogs+",'"+semail+"','"+scontact+"')";    		
    		int n =stmt.executeUpdate(qry);
    		System.out.println(n+"Record(s) Inserted");
    		con.close();
    		}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
	}
	
	public void updatestudent()
	{
		try 
    	{
    		Connection con = null;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12","root","Manvith@123");
    		System.out.println("Connection Established");
    		Statement stmt=con.createStatement();
    		int sid=103;
    		String sname="ram";
    		int sbacklogs=3;
    		
    		 String qry="update student set name='"+sname+"', backlogs="+sbacklogs+" where id="+sid+" ";
    		 int n =stmt.executeUpdate(qry);
    		System.out.println(n+"Record(s) Updated Successfully");
    		con.close();
    		}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
	}
	
	public void deletestudent()
	{
		try 
    	{
    		Connection con = null;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12","root","Manvith@123");
    		System.out.println("Connection Established");
    		Statement stmt=con.createStatement();
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Enter Stundet ID:");
    		int sid=sc.nextInt();
   		 String sql="delete from student where id="+sid+" ";
    		 int n =stmt.executeUpdate(sql);
    		System.out.println(n+"Record(s) Deleted Successfully");
    		con.close();
    		}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
	}
	public void viewallstudents()
	{
		try 
    	{
    		Connection con = null;
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12","root","Manvith@123");
    		System.out.println("Connection Established");
    		Statement stmt=con.createStatement();
   		 	String qry="select * from student";
    		ResultSet rs =stmt.executeQuery(qry);
    		while(rs.next()) 
    		{
        		System.out.println(rs.getInt(1)); // id
        		System.out.println(rs.getString(2)); // name
        		System.out.println(rs.getDouble(4)); // cgpa
        		System.out.println(rs.getString(7)); // contact number
        		System.out.println(rs.getString("gender")); // gender
        		System.out.println();
    		}
    		con.close();
    		}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
	}
}
