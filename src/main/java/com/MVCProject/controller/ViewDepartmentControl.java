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
import java.util.Optional;

import com.MVCProject.model.*;
import com.MVCProject.service.*;

@WebServlet("/viewdepartment")
public class ViewDepartmentControl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.html");
		requestDispatcher.include(request, response);

		out.println("<div class='container mt-5'>");

		// Heading
		out.println("<h1 class='text-center mb-4'>View All Departments</h1>");

		// Search bar
		out.println("<div class='row mb-3'>");
		out.println("<div class='col-md-6 mx-auto'>");
		out.println("<input type='text' class='form-control' placeholder='Search Department'>");
		out.println("</div>");
		out.println("</div>");

		// Responsive table
		out.println("<div class='table-responsive'>");

		// Table start
		out.println("<table class='table table-bordered table-hover table-dark text-center align-middle'>");

		// Table header
		out.println("<thead class='table-secondary text-dark'>");
		out.println("<tr>");
		out.println("<th>SR NO</th>");
		out.println("<th>DEPARTMENT NAME</th>");
		out.println("<th>UPDATE</th>");
		out.println("<th>DELETE</th>");
		out.println("</tr>");
		out.println("</thead>");

		// Table body
		out.println("<tbody>");

		DepartmentService deptService = new DepartmentServiceImpl();
		Optional<List<DepartmentModel>> o = deptService.getAllDepts();

		if (o.isPresent()) {

			List<DepartmentModel> list = o.get();
			int count = 0;

			if (list.isEmpty()) {

				out.println("<tr>");
				out.println("<td colspan='4' class='text-danger'>No Record Found</td>");
				out.println("</tr>");

			} else {

				for (DepartmentModel model : list) {

					++count;

					out.println("<tr>");

					out.println("<td>" + count + "</td>");
					out.println("<td>" + model.getDname() + "</td>");

					// Update Button
					out.println("<td>");
					out.println("<a name='update' href='updatedepartment?Id="
							+ model.getDid()
							+ "&DeptName="
							+ model.getDname()
							+ "' class='btn btn-warning btn-sm'>");

					out.println("<i class='bi bi-pencil-square'></i>");
					out.println("</a>");
					out.println("</td>");

					// Delete Button
					out.println("<td>");
					out.println("<a name='delete' href='deletedepartment?Id="
							+ model.getDid()
							+ "' class='btn btn-danger btn-sm'>");

					out.println("<i class='bi bi-trash'></i>");
					out.println("</a>");
					out.println("</td>");

					out.println("</tr>");
				}
			}

		} else {

			out.println("<tr>");
			out.println("<td colspan='4' class='text-danger'>Something Went Wrong</td>");
			out.println("</tr>");
		}

		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}