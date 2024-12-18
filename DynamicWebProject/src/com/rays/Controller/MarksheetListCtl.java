package com.rays.Controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.MarksheetBean;
import com.rays.Bean.UserBean;
import com.rays.Model.MarksheetModel;
import com.rays.Model.UserModel;

@WebServlet("/MarksheetListCtl.do")
public class MarksheetListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

		try {

			List list=model.search(bean, 1, 5);			
			request.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarksheetListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("operation=" + op);

		int pageNo = 1;
		int pageSize = 5;

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

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

				bean.setName(request.getParameter("name"));
				
				if(request.getParameter("rollno") != "") {
				bean.setRollno(Integer.parseInt(request.getParameter("rollno")));
				}
				
				if(request.getParameter("maths") != "") {
					
					System.out.println("aaya");
				bean.setMaths(Integer.parseInt(request.getParameter("maths")));
				}
				
			}
			if (op.equals("next")) {

				pageNo = Integer.parseInt(request.getParameter("pageNo"));

				pageNo++;
			}
			if (op.equals("previous")) {

				pageNo = Integer.parseInt(request.getParameter("pageNo"));

				pageNo--;
			}

			List list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);

			request.setAttribute("pageNo", pageNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarksheetListView.jsp");
		rd.forward(request, response);
	}

}
