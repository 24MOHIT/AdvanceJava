package com.rays.PreparedStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {

//		testadd();
		//testDelete();
		//testUpdate();
		testSearch();
		//testAuthenticate();

		
	}
	

	private static void testAuthenticate() throws Exception{
		
		UserModel model=new UserModel();
		
		UserBean bean=model.authenticate("ravi@gmail.com", "rk213");
		
		if (bean != null) {
			
			System.out.println(bean.getFirstname());
			System.out.println(bean.getLastname());
		}else {
			System.out.println("User Not Found");
		}
	}


	private static void testSearch() throws Exception {
			
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		UserModel model=new UserModel();
		
		UserBean bean=new UserBean();

		//search stringbuffer set name
//		bean.setFirstname("Shyam");
//		bean.setLastname("Ras");
//		bean.setLoginid("ravi@gmail.com");
//		bean.setAddress("Barwani");
		bean.setDob(sdf.parse("2001-01-04"));
		
		
		List list=model.search(bean, 1,5);
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			 bean = (UserBean)it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getFirstname());
			System.out.print("\t"+bean.getLastname());
			System.out.print("\t"+bean.getLoginid());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getAddress());
			System.out.println("\t"+bean.getDob());
		}
	}
	private static void testUpdate() throws Exception {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		
		UserModel model=new UserModel();
		
		UserBean bean=new UserBean();
		
		bean.setId(2);
		bean.setFirstname("Shyam");
		bean.setLastname("Kumhar");
		bean.setLoginid("shyam@gmail.com");
		bean.setPassword("sk213");
		bean.setAddress("Barwani");
		bean.setDob(sdf.parse("2001-03-04"));
		
		model.update(bean);
	}
	private static void testDelete() throws Exception {
		
		UserModel model= new UserModel();
		
		model.delete(4);
		
	}
	public static void testadd() throws Exception{
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		
		UserModel model=new UserModel();
		
		UserBean bean= new UserBean();
		
//		bean.setId(3);
		bean.setFirstname("Sahi");
		bean.setLastname("Jaat");
		bean.setLoginid("sj@gmail.com");
		bean.setPassword("sjj001");
		bean.setAddress("Rau");
		bean.setDob(sdf.parse("2001-01-20"));
		
		model.add(bean);
	}

	
}
