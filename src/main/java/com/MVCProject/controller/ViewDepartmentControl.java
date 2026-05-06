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
		out.println("<h1 class='text-center'>View All Departments</h1>");
		out.println("<div class='container mt-5'>");

		// Search bar
		out.println("<div class='mb-3'>");
		out.println("<input type='text' class='form-control' placeholder='Search data'>");
		out.println("</div>");

		// Table start
		out.println("<table class='table table-bordered table-dark text-center'>");

		// Table header
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>SRNO</th>");
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
				out.println("<tr><td colspan = '4' class='text-danger'>No Record Found</td></tr>");
			} else {

				for (DepartmentModel model : list) {
					++count;
					out.println("<tr>");
					out.println("<td>" + count + "</td>");
					out.println("<td>" + model.getDname() + "</td>");
					out.println("<td><a name='update' href='updatedepartment?Id=" + model.getDid() + "&DeptName="
							+ model.getDname() + "' class='text-warning'><i class='bi bi-pencil-square'></i></a></td>");
					out.println("<td><a name='delete' href='deletedepartment?Id=" + model.getDid()
							+ "' class='text-danger'><i class='bi bi-trash'></i></a></td>");
					out.println("</tr>");
				}
			}
		} else {

		}

		out.println("</tbody>");
		out.println("</table>");
		out.println("</div>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
