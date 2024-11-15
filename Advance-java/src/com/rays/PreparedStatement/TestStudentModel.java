package com.rays.PreparedStatement;

//import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
//import java.util.Date;

public class TestStudentModel {
	public static void main(String[] args) throws Exception {
		
		testAdd();
		//testUpdate();
		//testDelete();
		//testSearch();
	}

	private static void testSearch() throws Exception {

		StudentModel model =new StudentModel();
		StudentBean bean=new StudentBean();
		
		List list=model.search(bean);
		
		Iterator it= list.iterator();
		while (it.hasNext()) {
			bean=(StudentBean) it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getFirstname());
			System.out.print("\t"+bean.getLastname());
			System.out.print("\t"+bean.getCollagename());
			System.out.print("\t"+bean.getEmailid());
			System.out.print("\t"+bean.getMobileno());
			System.out.println("\t"+bean.getDob());
			
			
		}
	}

	private static void testDelete() throws Exception {

		StudentModel model=new StudentModel();
		StudentBean bean=new StudentBean();
		
		model.delete(4);	
	}

	private static void testUpdate() throws Exception {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		StudentModel model=new StudentModel();
		StudentBean bean=new StudentBean();
		
		bean.setId(4);
		bean.setFirstname("Vikas");
		bean.setLastname("Jaat");
		bean.setCollagename("Sage");
		bean.setEmailid("vk@gmail.com");
		bean.setMobileno("8976543212");
		bean.setDob(sdf.parse("2004-11-04"));
		
		model.update(bean);
	}

	private static void testAdd() throws Exception {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		StudentModel model=new StudentModel();
		StudentBean bean=new StudentBean();
		
		bean.setId(6);
		bean.setFirstname("Mukesh");
		bean.setLastname("Kumhar");
		bean.setCollagename("Niit");
		bean.setEmailid("mk@gmail.com");
		bean.setMobileno("9876543121");
		bean.setDob(sdf.parse("2000-10-04"));
		
		model.add(bean);
	}
}
