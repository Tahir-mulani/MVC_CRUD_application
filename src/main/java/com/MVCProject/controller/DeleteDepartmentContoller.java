package com.MVCProject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.MVCProject.service.DepartmentService;
import com.MVCProject.service.DepartmentServiceImpl;

@WebServlet("/deletedepartment")
public class DeleteDepartmentContoller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String s = request.getParameter("Id");
		PrintWriter out = response.getWriter();
		
		int n = Integer.parseInt(s);
		DepartmentService departmentService = new DepartmentServiceImpl();
		boolean result = departmentService.deleteDepartmentService(n);
		if (result) {
			out.println("<html><body><script>" + "alert('Department Deleted Successfully....!');"
					+ "window.location = 'viewdepartment';" + "</script></body></html>");
		} else {

			out.println("<html><body><script>" + "alert('Something Went Wrong....?'); "
					+ "window.location = 'dashboard.html'</script></body></html>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
