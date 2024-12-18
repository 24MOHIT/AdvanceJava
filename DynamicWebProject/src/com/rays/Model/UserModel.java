package com.rays.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.Bean.UserBean;
import com.rays.util.JDBCDataSource;

public class UserModel {

public int nextPK() throws Exception {
		
		int pk=0;
		
		Connection conn=JDBCDataSource.getconnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");
	
		ResultSet rs =pstmt.executeQuery();
		
		while (rs.next()) {
			pk=rs.getInt(1);
			System.out.println("max id"+pk);
		}
		return pk+1;
		
	}
	
	public void add(UserBean bean) throws Exception {

		Connection conn=JDBCDataSource.getconnection();
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

		Connection conn=JDBCDataSource.getconnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id=?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("Recode Delete=" + i);
	}

	public void update(UserBean bean) throws Exception {

		Connection conn=JDBCDataSource.getconnection();
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

		Connection conn=JDBCDataSource.getconnection();		
		
		//using stringbuffer
		StringBuffer sql=new StringBuffer("select * from st_user where 1=1 ");
		
		if (bean !=null) {
			if (bean.getFirstname() !=null && bean.getFirstname().length() > 0) {
				sql.append(" and firstname like '"+bean.getFirstname()+"'");
			}
	
		
			if (bean.getLastname() !=null && bean.getLastname().length() > 0) {
				sql.append(" and lastname like '"+bean.getLastname()+"'");
			}

			if (bean.getLoginid() != null && bean.getLoginid().length() > 0) {
				sql.append(" and loginid like '"+bean.getLoginid()+"'");				
			}
		
			if (bean.getAddress() != null && bean.getAddress().length() > 0) {
				sql.append(" and address like '"+bean.getAddress()+"'");
				
			}
			
			if (bean.getDob() !=null && bean.getDob().getTime() > 0) {
				
			Date d=new Date(bean.getDob().getTime());
			
			sql.append(" and dob like '"+ d + "'");
				
			}
		}
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
		
		Connection conn=JDBCDataSource.getconnection();
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
		
		Connection conn=JDBCDataSource.getconnection();
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

	public UserBean findById(int id) throws Exception {

		Connection conn = JDBCDataSource.getconnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

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
