package com.rays.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.MarksheetBean;
import com.rays.Model.MarksheetModel;

@WebServlet("/MarksheetCtl.do")
public class MarksheetCtl extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("MarksheetView.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MarksheetModel model =new MarksheetModel();
		MarksheetBean bean=new MarksheetBean();
		
		String rollno=request.getParameter("rollno");
		String name=request.getParameter("name");
		String maths=request.getParameter("maths");
		String physics=request.getParameter("physics");
		String chemistry=request.getParameter("chemistry");		
		
		try {
			bean.setRollno(Integer.parseInt(rollno));
			bean.setName(name);
			bean.setMaths(Integer.parseInt(maths));
			bean.setPhysics(Integer.parseInt(physics));
			bean.setChemistry(Integer.parseInt(chemistry));		
			
			model.add(bean);
			request.setAttribute("msg", "Data Add Successfully");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(request, response);
	}
}
