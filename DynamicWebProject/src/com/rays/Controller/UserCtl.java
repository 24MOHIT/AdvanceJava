package com.rays.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.UserBean;
import com.rays.Model.UserModel;

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		System.out.println("id= "+id);
		
		UserModel model=new UserModel();
		UserBean bean=new UserBean();
	
		if (id != null) {
			try {
				bean=model.findById(Integer.parseInt(id));
				request.setAttribute("bean", bean);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("UserView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op=request.getParameter("operation");
		System.out.println("op="+op);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model=new UserModel();
		UserBean bean=new UserBean();
		
		String firstname=request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		String loginid=request.getParameter("loginid");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String dob=request.getParameter("dob");
		
		try {
			bean.setFirstname(firstname);
			bean.setLastname(lastname);
			bean.setLoginid(loginid);
			bean.setPassword(password);
			bean.setAddress(address);
			bean.setDob(sdf.parse(dob));
			
			if (op.equals("save")) {
				
				model.add(bean);
				request.setAttribute("bean", bean);
				request.setAttribute("msg", "User Added Successfully");	
				
			}else if (op.equals("update")) {
				bean.setId(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("bean", bean);
				model.update(bean);
				request.setAttribute("msg", "User Update Successfully");
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("UserView.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}


