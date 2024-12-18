package com.rays.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.StudentBean;
import com.rays.Model.StudentModel;

@WebServlet("/StudentCtl.do")
public class StudentCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("id : " + id);

		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();

		if (id != null) {
System.out.println("aaya");
			try {
				System.out.println("yha b aaya");
				bean = model.findByid(Integer.parseInt(id));
				request.setAttribute("bean", bean);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("op : " + op);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String collagename = request.getParameter("collagename");
		String emailid = request.getParameter("emailid");
		String mobileno = request.getParameter("mobileno");
		String dob = request.getParameter("dob");
		try {

			bean.setFirstname(firstname);
			bean.setLastname(lastname);
			bean.setCollagename(collagename);
			bean.setEmailid(emailid);
			bean.setMobileno(mobileno);
			bean.setDob(sdf.parse(dob));
			
			if (op.equals("save")) {
				
				model.add(bean);
				request.setAttribute("bean", bean);
				request.setAttribute("msg", "Data Add Successfully...");
				
			} else if (op.equals("update")) {
				
				bean.setId(Integer.parseInt(request.getParameter("id")));
				
				model.update(bean);
				request.setAttribute("bean", bean);
				request.setAttribute("msg", "Data Update Successfully...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
		rd.forward(request, response);
	}
}
