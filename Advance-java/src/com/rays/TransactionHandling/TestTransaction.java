package com.rays.TransactionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {
	
	public static void main(String[] args) throws Exception {
	
		Connection conn=null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");	
			
			conn.setAutoCommit(false);
			Statement stmt=conn.createStatement();

				int i=stmt.executeUpdate("insert into st_user values(3,'Sany','Ras','sr@gmail.com','s001','Rau','2001-02-20')");
			
	       		 i=stmt.executeUpdate("insert into st_user values(3,'Sany','Ras','sr@gmail.com','s001','Rau','2001-02-20')");
			
				 i=stmt.executeUpdate("insert into st_user values(3,'Sany','Ras','sr@gmail.com','s001','Rau','2001-02-20')");//				
				 i=stmt.executeUpdate("insert into st_user values(3,'Sany','Ras','sr@gmail.com','s001','Rau','2001-02-20')");
				
				 conn.commit();
				 
		} catch (Exception e) {
			
			conn.rollback();
			System.out.println(e.getMessage());
		}
}
}
