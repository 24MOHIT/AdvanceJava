package com.rays.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.CollegeBean;
import com.rays.Model.CollegeModel;

@WebServlet("/CollegeCtl.do")
public class CollegeCtl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String id=request.getParameter("id");
    	System.out.println("id"+id);
    	
    	CollegeModel model=new CollegeModel();
    	CollegeBean bean=new CollegeBean();
    	
    	if (id != null) {
			
    		try {
				bean=model.findById(Integer.parseInt(id));
				request.setAttribute("bean", bean);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

        // Forwarding the request instead of redirecting
        RequestDispatcher rd = request.getRequestDispatcher("CollegeView.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op=request.getParameter("operation");
        System.out.println(op);

        // Creating model and bean objects
        CollegeModel model = new CollegeModel();
        CollegeBean bean = new CollegeBean();

     // Fetching form parameters
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String phoneno = request.getParameter("phoneno");
      
        try {
        // Setting bean properties
        bean.setName(name);
        bean.setAddress(address);
        bean.setState(state);
        bean.setCity(city);
        bean.setPhoneno(phoneno);

      
            // Inserting data into the database
      if (op.equals("save")){
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

        // Forwarding the request to the view
        RequestDispatcher rd = request.getRequestDispatcher("CollegeView.jsp");
        rd.forward(request, response);
    }                                    
}
