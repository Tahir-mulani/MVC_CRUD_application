package com.MVCProject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/validateadmin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 if((username.equals("admin")) && (password.equals("admin")))
		 {
			  out.println("<html><body><script>"
			  		+ "alert('Login Successfull....!'); "
			  		+ "window.location = 'dashboard.html'</script></body></html>");
		 } else {
			 out.println("<h1>Login Unsuccessfull</h1>");
		 }
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
