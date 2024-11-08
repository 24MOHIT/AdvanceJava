package com.rays.JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestUser {
	public static void main(String[] args) throws Exception {
		// adduser();
		// deleteuser();
		// updateuser();
		search();
	}

	private static void adduser() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into st_user values(2,'Shyam','Verma','shyam@gmail.com','pass12','Indore','2003-06-23')");

		System.out.println(i + "Record Add");
	}

	private static void deleteuser() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("delete from st_user where id=2");

		System.out.println(i + "Record Delete");
	}

	private static void updateuser() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("update st_user set firstname='Aman' where id=2");

		System.out.println(i + "Record Update");
	}

	private static void search() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from st_user");

		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getString(6));
			System.out.println("\t"+rs.getDate(7));
		}
	}

}
