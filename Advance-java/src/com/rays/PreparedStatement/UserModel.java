package com.rays.PreparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserModel {

	ResourceBundle rb=ResourceBundle.getBundle("com.rays.bundle.system");
	
	
	public int nextPK() throws Exception {
		
		int pk=0;
		
		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");
	
		ResultSet rs =pstmt.executeQuery();
		
		while (rs.next()) {
			pk=rs.getInt(1);
			System.out.println("max id"+pk);
		}
		return pk+1;
		
	}
	
	public void add(UserBean bean) throws Exception {

		Class.forName(rb.getString("driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));

		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?,?)");
	
			UserBean existsbean =new UserBean();
			
			System.out.println("Loginid="+bean.getLoginid());
			
			existsbean=findByLoginId(bean.getLoginid());
			
			if (existsbean !=null) {
				System.out.println("Loginid already exists");
			}else {
		
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getFirstname());
			pstmt.setString(3, bean.getLastname());
			pstmt.setString(4, bean.getLoginid());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6, bean.getAddress());
			pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();
			System.out.println("Data Add Successfully=" + i);
			}
	}
	

	public void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id=?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("Recode Delete=" + i);
	}

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user set firstname=?, lastname=?,loginid=?, password=?, address=?, dob=?  where id=?");

		pstmt.setString(1, bean.getFirstname());
		pstmt.setString(2, bean.getLastname());
		pstmt.setString(3, bean.getLoginid());
		pstmt.setString(4, bean.getPassword());
		pstmt.setString(5, bean.getAddress());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(7, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Recode Update=" + i);
	}

	public List search(UserBean bean, int pageNo , int pageSize ) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		//using stringbuffer
		StringBuffer sql=new StringBuffer("select * from st_user where 1=1 ");
		
		if (bean !=null) {
			if (bean.getFirstname() !=null && bean.getFirstname().length() > 0) {
				sql.append(" and firstname like '"+bean.getFirstname()+"'");
			}
		}
		
		if (bean !=null) {
			if (bean.getLastname() !=null && bean.getLastname().length() > 0) {
				sql.append(" and lastname like '"+bean.getLastname()+"'");
			}
		}
		
////		if (bean !=null) {
////			if (bean.getLoginid() !=null && bean.getLoginid().length() > 0) {
////				sql.ap
////			}
//			
//		}
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			sql.append(" limit " + pageNo + "," + pageSize);

		}
	
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		
		System.out.println("sql="+sql.toString());
		
		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));

			list.add(bean);
		}
		return list;
	}
	
	public UserBean authenticate(String loginid, String password) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		PreparedStatement pstmt=conn.prepareStatement("select * from st_user where loginid=? and password=?");
		
		pstmt.setString(1, loginid);
		pstmt.setString(2, password);
		
		ResultSet rs=pstmt.executeQuery();
		
		UserBean bean= null;
		
		while (rs.next()) {
			
		 bean=new UserBean();
		 
		 bean.setId(rs.getInt(1));
		 bean.setFirstname(rs.getString(2));
		 bean.setLastname(rs.getString(3));
		 bean.setLoginid(rs.getString(4));
		 bean.setPassword(rs.getString(5));
		 bean.setPassword(rs.getString(6));
		 bean.setDob(rs.getDate(7));
		 		
		}
		return bean;
	}
	
	public  UserBean findByLoginId(String loginid) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		PreparedStatement pstmt=conn.prepareStatement("select * from st_user where loginid=?");
		
		pstmt.setString(1, loginid);
		
		ResultSet rs=pstmt.executeQuery();
		
		UserBean bean=null;
		
		while (rs.next()) {
			
			bean=new UserBean();
			
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginid(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));
		}
	return bean;
	}
}
