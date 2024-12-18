package com.rays.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.StudentBean;
import com.rays.Model.StudentModel;

@WebServlet("/StudentListCtl.do")
public class StudentListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();

		try {
			List list = model.search(bean, 1,5);
			request.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("StudentListView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("op : " + op);
		
		int pageNo=1;
		int pageSize=5;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();

		String[] ids = request.getParameterValues("ids");
		try {
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

			if (op.equals("search")) {

				bean.setFirstname(request.getParameter("firstname"));
				bean.setLastname(request.getParameter("lastname"));

				if (request.getParameter("dob") != "") {
					bean.setDob(sdf.parse(request.getParameter("dob")));
				}
			}
			
			if (op.equals("next")) {
				
				pageNo=Integer.parseInt(request.getParameter("pageNo"));
				
				pageNo++;
			}
			
			if (op.equals("previous")) {
				
				pageNo=Integer.parseInt(request.getParameter("pageNo"));
				
				pageNo--;
			}
			
			List list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			
			request.setAttribute("pageNo", pageNo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		RequestDispatcher rd = request.getRequestDispatcher("StudentListView.jsp");
		rd.forward(request, response);
	}
}
