package com.rays.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {
	
	ResourceBundle rb=ResourceBundle.getBundle("com.rays.Bundle.system");
	
	public int nextPK() throws Exception {

		int pk=0;
		Class.forName(rb.getString("driver"));
		Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
		PreparedStatement pstmt=conn.prepareStatement("select max(id) from marksheet");
		
		ResultSet rs=pstmt.executeQuery();
		
		while (rs.next()) {
			
			pk=rs.getInt(1);
			System.out.println("Max id="+pk);
		}
		return pk+1;
	}

	public void add(MarksheetBean bean) throws Exception {
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
	PreparedStatement pstmt=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
	
	MarksheetBean existsbean=new MarksheetBean();
	
	System.out.println("Rollno="+bean.getRollno());
	existsbean=findByRollno(bean.getRollno());
	
	if (existsbean !=null) {
		System.out.println("Rollno Already Exists");
	}else {
	pstmt.setInt(1, nextPK());
	pstmt.setInt(2, bean.getRollno());
	pstmt.setString(3, bean.getName());
	pstmt.setInt(4, bean.getMaths());
	pstmt.setInt(5, bean.getPhysics());
	pstmt.setInt(6, bean.getChemistry());
	
	int i=pstmt.executeUpdate();
	System.out.println("Data Add Successfuely"+i);
	}
	}
	
	public MarksheetBean findByRollno(int rollno) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
		PreparedStatement pstmt=conn.prepareStatement("select * from marksheet where rollno=?");
		
		pstmt.setInt(1, rollno);
		
		ResultSet rs=pstmt.executeQuery();
		
		MarksheetBean bean=null;
		
		while (rs.next()) {
			
			bean=new MarksheetBean();
			
		bean.setId(rs.getInt(1));
		bean.setRollno(rs.getInt(2));
		bean.setName(rs.getString(3));
		bean.setMaths(rs.getInt(4));
		bean.setPhysics(rs.getInt(5));
		bean.setChemistry(rs.getInt(6));
		}
		return bean;
		}
	
	public void delete(int id) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
		PreparedStatement pstmt=conn.prepareStatement("delete from marksheet where id=?");
		
		pstmt.setInt(1, id);
		int i=pstmt.executeUpdate();
		System.out.println("Data Delete="+i);
	}
	
	public void update(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
		PreparedStatement pstmt=conn.prepareStatement("update marksheet set rollno=?, name=?, maths=?, physics=?, chemistry=? where id =?");
		
		pstmt.setInt(1, bean.getRollno());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getMaths());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getId());
		
		int i=pstmt.executeUpdate();
		System.out.println("Data Upadate="+i);
		}
	public List search(MarksheetBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
		PreparedStatement pstmt=conn.prepareStatement("select * from marksheet");
		
		ResultSet rs =pstmt.executeQuery();
		
		List list=new ArrayList();
		
		while(rs.next()) {

			bean = new MarksheetBean();
					
		bean.setId(rs.getInt(1));
		bean.setRollno(rs.getInt(2));
		bean.setName(rs.getString(3));
		bean.setMaths(rs.getInt(4));
		bean.setPhysics(rs.getInt(5));
		bean.setChemistry(rs.getInt(6));
		
		list.add(bean);
		}
		return list;
		}
	
//	public void MeritList() throws Exception {
//		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","root");
//		PreparedStatement pstmt=conn.prepareStatement("");
//	}
}
