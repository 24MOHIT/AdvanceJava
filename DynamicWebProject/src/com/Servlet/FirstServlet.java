package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Defult me doGet method chlegi
		System.out.println("in a doget method");
		response.sendRedirect("First.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in a dopost method");
		System.out.println(request.getParameter("firstname"));
		System.out.println(request.getParameter("lastname"));
		System.out.println(request.getParameter("loginid"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("address"));
		System.out.println(request.getParameter("dob"));
	
	}
	
}
