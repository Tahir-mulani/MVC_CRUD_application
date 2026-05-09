package com.MVCProject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import com.MVCProject.model.EmployeeModel;
import com.MVCProject.service.EmployeeService;
import com.MVCProject.service.EmployeeServiceImpl;
 
@WebServlet("/deleteEmployee")
public class DeleteEmployeeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n =request.getParameter("delete");
		int id = Integer.parseInt(n);
		 
		
		EmployeeModel model = new EmployeeModel();
		EmployeeService empService = new EmployeeServiceImpl();
		boolean result = empService.deleteEmployee(id);
		if (result) {
			out.println("<html><body><script>" + "alert('Department Deleted Successfully....!');"
					+ "window.location = 'viewdepartment';" + "</script></body></html>");
		} else {

			out.println("<html><body><script>" + "alert('Something Went Wrong....?'); "
					+ "window.location = 'dashboard.html'</script></body></html>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
