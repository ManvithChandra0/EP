package com.klef.ep.JDBCProject;
import java.sql.*;

public class DBConnection 
{

    public static void main( String[] args )
    {
    	try 
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Class Loaded");
    		DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcs12","root","Manvith@123");
    		System.out.println("Connection Established");
    	}
    	catch(Exception e) 
    	{
			System.out.println(e);
		}
    }
	
}
