package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCconnection {
	public static void main(String[] args) throws Exception {

		//step 1. Load Mysql Driver (Class Loader)
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step 2. Create Connection
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","root");
		
		//step 3. Create Statement object
		Statement stmt=conn.createStatement();
		
		//step 4. Crete Query
		  ResultSet rs=stmt.executeQuery("select * from employee");
		//ResultSet rs=stmt.executeQuery("select id, name from employee");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getInt(4));
			System.out.println("\t"+rs.getString(5));
		}
	}

}
