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

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("UserRegistrationView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String loginid = request.getParameter("loginid");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");

		try {

			bean.setFirstname(firstname);
			bean.setLastname(lastname);
			bean.setLoginid(loginid);
			bean.setPassword(password);
			bean.setAddress(address);
			bean.setDob(sdf.parse(dob));

			if (model.findByLoginId(loginid) != null) {

				request.setAttribute("err", "LoginId Allready Exist...");
			} else {

				model.add(bean);
				request.setAttribute("msg", "User Registration Successfully");

			}

			RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");

			rd.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
