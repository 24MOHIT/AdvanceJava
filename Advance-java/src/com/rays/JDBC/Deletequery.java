package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Deletequery {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","root");
		
		Statement stmt=conn.createStatement();
		
		int i=stmt.executeUpdate("delete from employee where id=10");
		
		System.out.println(i+ "Record Delete");
	}

}
