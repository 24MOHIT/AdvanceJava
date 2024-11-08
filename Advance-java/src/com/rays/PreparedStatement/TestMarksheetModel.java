package com.rays.PreparedStatement;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {

//	    testAdd();
//		testDelete();
//		testUpdate();
	search();

	}

	private static void search() throws Exception {
		
		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=new MarksheetBean();
		
		List list=model.search(bean);
		
		Iterator it=list.iterator();
		while (it.hasNext()) {
			bean=(MarksheetBean)it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getRollno());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getMaths());
			System.out.print("\t"+bean.getPhysics());
			System.out.println("\t"+bean.getChemistry());
			
		}
		
	}

	private static void testUpdate() throws Exception {

		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=new MarksheetBean();
		
		bean.setId(11);
		bean.setRollno(111);
		bean.setName("Raj");
		bean.setMaths(79);
		bean.setPhysics(56);
		bean.setChemistry(59);
		
		model.update(bean);
	}

	private static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.delete(14);
	}

	private static void testAdd() throws Exception {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

		bean.setRollno(113);
		bean.setName("Green");
		bean.setMaths(63);
		bean.setPhysics(65);
		bean.setChemistry(49);

		model.add(bean);

	}
	
}
