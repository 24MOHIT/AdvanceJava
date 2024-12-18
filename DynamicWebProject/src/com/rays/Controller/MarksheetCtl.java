package com.rays.Controller;

import java.io.IOException;

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

@WebServlet("/MarksheetCtl.do")
public class MarksheetCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rollno = request.getParameter("rollno");
		System.out.println("Rollno" + rollno);

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

		if (rollno != null) {
			try {
				bean = model.findByRollno(Integer.parseInt(rollno));
				request.setAttribute("bean", bean);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op=request.getParameter("operation");
		System.out.println("op="+ op);

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

		String rollno = request.getParameter("rollno");
		String name = request.getParameter("name");
		String maths = request.getParameter("maths");
		String physics = request.getParameter("physics");
		String chemistry = request.getParameter("chemistry");

		try {
			bean.setRollno(Integer.parseInt(rollno));
			bean.setName(name);
			bean.setMaths(Integer.parseInt(maths));
			bean.setPhysics(Integer.parseInt(physics));
			bean.setChemistry(Integer.parseInt(chemistry));

			if (model.findByRollno(Integer.parseInt(rollno)) != null) {
				
				request.setAttribute("msg", "Rollno AllReady Exist...");
				
			}else if (op.equals("save")) {
				
				model.add(bean);
				request.setAttribute("bean", bean);
				request.setAttribute("msg", "Data Add Successfully");
			
			}
			if (op.equals("update")) {
				
				bean.setId(Integer.parseInt(request.getParameter("id")));
				
				model.update(bean);
				request.setAttribute("bean", bean);
				request.setAttribute("msg", "Data Update Successfully");
			}
			

		} catch (Exception e) {

			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(request, response);
	}
}
