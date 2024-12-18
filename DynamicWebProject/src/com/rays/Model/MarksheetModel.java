package com.rays.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.Bean.MarksheetBean;
import com.rays.util.JDBCDataSource;

public class MarksheetModel {

	
	public int nextPK() throws Exception {

		int pk=0;
		
		Connection conn=JDBCDataSource.getconnection();
		PreparedStatement pstmt=conn.prepareStatement("select max(id) from st_marksheet");
		
		ResultSet rs=pstmt.executeQuery();
		
		while (rs.next()) {
			
			pk=rs.getInt(1);
			System.out.println("Max id="+pk);
		}
		return pk+1;
	}

	public void add(MarksheetBean bean) throws Exception {
		
		Connection conn=JDBCDataSource.getconnection();
		
	PreparedStatement pstmt=conn.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?)");
	
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
	System.out.println("Data Add Successfuely-"+i);
	}
	}
	
	public MarksheetBean findByRollno(int rollno) throws Exception {
		
		Connection conn=JDBCDataSource.getconnection();
		PreparedStatement pstmt=conn.prepareStatement("select * from st_marksheet where rollno=?");
		
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
		
		Connection conn=JDBCDataSource.getconnection();
		PreparedStatement pstmt=conn.prepareStatement("delete from st_marksheet where id=?");
		
		pstmt.setInt(1, id);
		int i=pstmt.executeUpdate();
		System.out.println("Data Delete="+i);
	}
	
	public void update(MarksheetBean bean) throws Exception {
		
		Connection conn =JDBCDataSource.getconnection();
		PreparedStatement pstmt=conn.prepareStatement("update st_marksheet set rollno=?, name=?, maths=?, physics=?, chemistry=? where id =?");
		
		pstmt.setInt(1, bean.getRollno());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getMaths());
		pstmt.setInt(4, bean.getPhysics());
		pstmt.setInt(5, bean.getChemistry());
		pstmt.setInt(6, bean.getId());
		
		int i=pstmt.executeUpdate();
		System.out.println("Data Upadate="+i);
		}
	public List search(MarksheetBean bean, int pageNo, int pagesize) throws Exception {
		
		Connection conn=JDBCDataSource.getconnection();
		
		StringBuffer sql=new StringBuffer("select * from st_marksheet where 1=1");
			
		
		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '"+bean.getName()+ "'");	
				}
			
			if ( bean.getRollno() != 0 && bean.getRollno() > 0 ) {
				sql.append(" and rollno = "+ bean.getRollno() + "");
			}
			
			if (bean.getMaths() != 0 && bean.getMaths() > 0) {
				sql.append(" and maths = "+ bean.getMaths() + "");
			}
			
		}
		
		if (pagesize > 0) {
			
			pageNo= (pageNo - 1)* pagesize ;
			sql.append(" limit " + pageNo + ","+ pagesize);
		}
		
		PreparedStatement pstmt=conn.prepareStatement(sql.toString());
		
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
	
}
