package com.rays.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.Bean.StudentBean;
import com.rays.util.JDBCDataSource;

public class StudentModel {

	public int nextpk() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getconnection();
		PreparedStatement pstmt = conn.prepareStatement(" select max(id) from st_student");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id=" + pk);
		}
		return pk + 1;

	}

	public void add(StudentBean bean) throws Exception {

		Connection conn = JDBCDataSource.getconnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into st_student values(?,?,?,?,?,?,?)");

		StudentBean existbean = new StudentBean();

		System.out.println("id-" + bean.getId());
		existbean = findByid(bean.getId());

		if (existbean != null) {
			System.out.println("ID Allready Exist");
		}

		System.out.println("Emailid is -" + bean.getEmailid());
		existbean = findByemailid(bean.getEmailid());

		if (existbean != null) {
			System.out.println("Login Emailid Allready Exist ");
		} else {

			pstmt.setInt(1, nextpk());
			pstmt.setString(2, bean.getFirstname());
			pstmt.setString(3, bean.getLastname());
			pstmt.setString(4, bean.getCollagename());
			pstmt.setString(5, bean.getEmailid());
			pstmt.setString(6, bean.getMobileno());
			pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();
			System.out.println("Data Add Successfully:-" + i);
		}
	}

	public void update(StudentBean bean) throws Exception {

		Connection conn = JDBCDataSource.getconnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"update st_student set firstname=?, lastname=?, collagename=?, emailid=?, mobileno=?, dob=? where id=?");

		pstmt.setString(1, bean.getFirstname());
		pstmt.setString(2, bean.getLastname());
		pstmt.setString(3, bean.getCollagename());
		pstmt.setString(4, bean.getEmailid());
		pstmt.setString(5, bean.getMobileno());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(7, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data Update Successfully:-" + i);
	}

	public void delete(int id) throws Exception {

		Connection conn = JDBCDataSource.getconnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from st_student where id=?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("Data Delete :" + i);
	}

	public List search(StudentBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getconnection();

		StringBuffer sql = new StringBuffer("select * from st_student where 1=1");

		if (bean != null) {

			if (bean.getFirstname() != null && bean.getFirstname().length() > 0) {
				sql.append(" and firstname like '" + bean.getFirstname() + "'");
			}

			if (bean.getLastname() != null && bean.getLastname().length() > 0) {
				sql.append(" and lastname like '" + bean.getLastname() + "'");
			}
			
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				
				Date d=new Date(bean.getDob().getTime());
				sql.append(" and dob like '" + d + "'");
			}

		}
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		System.out.println("sql : " + sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setCollagename(rs.getString(4));
			bean.setEmailid(rs.getString(5));
			bean.setMobileno(rs.getString(6));
			bean.setDob(rs.getDate(7));

			list.add(bean);
		}
		return list;
	}

	public StudentBean findByemailid(String emailid) throws Exception {

		Connection conn = JDBCDataSource.getconnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_student where emailid=?");

		pstmt.setString(1, emailid);
		ResultSet rs = pstmt.executeQuery();

		StudentBean bean = null;
		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setCollagename(rs.getString(4));
			bean.setEmailid(rs.getString(5));
			bean.setMobileno(rs.getString(6));
			bean.setDob(rs.getDate(7));
		}
		return bean;
	}

	public StudentBean findByid(int id) throws Exception {

		Connection conn = JDBCDataSource.getconnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_student where id=?");

		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();

		StudentBean bean = null;
		while (rs.next()) {

			bean = new StudentBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setCollagename(rs.getString(4));
			bean.setEmailid(rs.getString(5));
			bean.setMobileno(rs.getString(6));
			bean.setDob(rs.getDate(7));
		}
		return bean;

	}
}
