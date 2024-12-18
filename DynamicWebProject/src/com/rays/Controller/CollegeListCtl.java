package com.rays.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.CollegeBean;
import com.rays.Model.CollegeModel;

@WebServlet("/CollegeListCtl.do")
public class CollegeListCtl extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CollegeModel model=new CollegeModel();
		CollegeBean bean=new CollegeBean();
		
		try {
			List list=model.search(bean, 1,5);
			request.setAttribute("list", list);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("CollegeListView.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op=request.getParameter("operation");
		System.out.println("op="+op);
		
		int pageNo=1;
		int pageSize=5;
		
		CollegeModel model=new CollegeModel();
		CollegeBean bean=new CollegeBean();
		
		String [] ids=request.getParameterValues("ids");
		
		if (op.equals("delete")) {
			
			for (String id : ids) {
				
				try {
					model.delete(Integer.parseInt(id));				
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			if (op.equals("search")) {
				
				bean.setName(request.getParameter("name"));
			}
			
			if (op.equals("next")) {
			
				pageNo=Integer.parseInt(request.getParameter("pageNo"));
				
				pageNo++;
			}
			if (op.equals("previous")) {
				
				pageNo=Integer.parseInt(request.getParameter("pageNo"));
				pageNo--;
			}
			
			
			List list=model.search(bean, pageNo,pageSize);
			request.setAttribute("list", list);
			
			request.setAttribute("pageNo", pageNo);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher rd=request.getRequestDispatcher("CollegeListView.jsp");
		rd.forward(request, response);
	}
	
}
