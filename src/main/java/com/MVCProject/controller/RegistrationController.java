package com.MVCProject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.MVCProject.model.UserModel;
import com.MVCProject.service.RegisterUserService;
import com.MVCProject.service.RegisterUserServiceImpl;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String btnRegister = request.getParameter("btnsubmit");
		int cnt = 0;
		if(btnRegister != null)
		{
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserModel usermodel = new UserModel(cnt,name,email,contact,username,password);
			
			RegisterUserService registerService = new RegisterUserServiceImpl();
			Boolean result = registerService.registerUser(usermodel);

			if (result) {
				out.println(
						"<html><body><script>" + "alert('User Registered Successfully....!');</script></body></html>");
			} else {

				out.println("<html><body><script>"
						+ "alert('Something Went Wrong....?'); window.location = 'dashboard.html'</script></body></html>");
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
