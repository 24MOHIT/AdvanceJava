package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insertquery {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","root");

	    Statement stmt=conn.createStatement();
	    
	    int i=stmt.executeUpdate("insert into employee values(11,'Mahi','MDC',50000,'Rau',null)");
	   
	    System.out.println(i+ "Record Insert");
	}

}
