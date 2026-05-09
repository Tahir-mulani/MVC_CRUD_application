package com.MVCProject.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.MVCProject.model.EmployeeModel;
import com.MVCProject.service.EmployeeService;
import com.MVCProject.service.EmployeeServiceImpl;

@WebServlet("/viewemployee")
public class ViewEmployeeControl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		RequestDispatcher rd = request.getRequestDispatcher("dashboard.html");
		rd.include(request, response);

		out.println("<div class='container mt-5'>");

		// Heading
		out.println("<h1 class='text-center mb-4'>View All Employees</h1>");

		// Search Bar
		out.println("<div class='row mb-3'>");
		out.println("<div class='col-md-6 mx-auto'>");
		out.println("<input type='text' class='form-control' placeholder='Search Employee'>");
		out.println("</div>");
		out.println("</div>");

		// Responsive Table
		out.println("<div class='table-responsive'>");

		out.println("<table class='table table-bordered table-hover table-dark text-center align-middle'>");

		// Table Header
		out.println("<thead class='table-secondary text-dark'>");
		out.println("<tr>");
		out.println("<th>SR NO</th>");
		out.println("<th>EMPLOYEE NAME</th>");
		out.println("<th>EMAIL</th>");
		out.println("<th>DEPARTMENT</th>");
		out.println("<th>CONTACT</th>");
		out.println("<th>SALARY</th>");
		out.println("<th>UPDATE</th>");
		out.println("<th>DELETE</th>");
		out.println("</tr>");
		out.println("</thead>");

		// Table Body
		out.println("<tbody>");

		EmployeeService empService = new EmployeeServiceImpl();
		List<Object[]> list = empService.getAllEmployeeWithDepartment();
		EmployeeModel empModel = new EmployeeModel();
		
		int count = 0;
		if (list.isEmpty()) {

			out.println("<tr>");
			out.println("<td colspan='8' class='text-danger'>No Record Found</td>");
			out.println("</tr>");

		} else {
			for (Object obj[] : list) {

				count++;

				out.println("<tr>");

				out.println("<td>" + count + "</td>");
				out.println("<td>" + obj[0] + "</td>");
				out.println("<td>" + obj[1] + "</td>");
				out.println("<td>" + obj[2] + "</td>");
				out.println("<td>" + obj[3] + "</td>");
				out.println("<td>" + obj[4] + "</td>");

				out.println("<td>");
				out.println("<a href='' class='btn btn-warning btn-sm'>");
				out.println("<i class='bi bi-pencil-square'></i>");
				out.println("</a>");
				out.println("</td>");

				out.println("<td>");
				out.println("<a name='delete' href='deleteEmployee?Id="
						+empModel.getId()+""
						+ "' class='btn btn-danger btn-sm'>");

				out.println("<i class='bi bi-trash'></i>");
				out.println("</a>");
				out.println("</td>");

				out.println("</tr>");
			}

			out.println("</tbody>");
			out.println("</table>");
			out.println("</div>");
			out.println("</div>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}