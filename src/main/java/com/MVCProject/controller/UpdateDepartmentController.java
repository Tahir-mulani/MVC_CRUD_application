package com.MVCProject.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

/**
 * Servlet implementation class UpdateDepartmentController
 */
@WebServlet("/updatedepartment")
public class UpdateDepartmentController extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String department = request.getParameter("DeptName");
		
		RequestDispatcher r = request.getRequestDispatcher("dashboard.html");
		r.include(request, response);
		out.println("<h1 class='text-center'>Update Department</h1>");
		out.println("<div class='container bg-dark mt-5 p-5'>");
		out.println("<form action='editupdatedepartment' method='post'>");

		// 🔹 Department ID (rottenly)
		/*out.println("<div class='mb-3'>");
		out.println("<label class='form-label text-white'>SR NO.</label>");
		out.println("<input type='text' name='deptId' class='form-control' value='" + n + "'>");
		out.println("</div>");
*/
		// 🔹 Department Name
		out.println("<div class='mb-3'>");
		out.println("<label class='form-label text-white'>Department Name</label>");
		out.println("<input type='text' name='deptName' class='form-control' value='" + department + "'>");
		out.println("</div>");

		// 🔹 Submit button
		out.println("<div class='text-center'>");
		out.println("<button type='submit' class='btn btn-light px-4'>Update</button>");
		out.println("</div>");

		out.println("</form>");
		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
