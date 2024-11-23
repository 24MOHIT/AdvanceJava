package com.rays.Cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookies")
public class GetCookies extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		Cookie [] cookie=request.getCookies();
		
		for (int i = 0; i < cookie.length; i++) {
			
			Cookie c=cookie[i];
			
			String name=c.getName();
			String value=c.getValue();
			
			out.println(name+""+value);
		}
	}
}
