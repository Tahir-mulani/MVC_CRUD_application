package com.MVCProject.controller;

import com.MVCProject.model.DepartmentModel;
import com.MVCProject.model.EmployeeModel;
import com.MVCProject.service.*;

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

import javax.management.modelmbean.ModelMBean;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/addemployee")
public class AddEmployeeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.html");
		requestDispatcher.include(request, response);
		EmployeeService emplService = new EmployeeServiceImpl();

		out.println("<h1 class='text-center mt-4'>Add New Employee</h1>");

		out.println("<form  name='frm' action='' method='post'>");

		out.println("<div class='container mt-5'>");
		out.println("<div class='row justify-content-center'>");
		out.println("<div class='col-md-8'>");

		out.println("<div class='card shadow p-4 bg-dark text-white rounded'>");

		// Row 1 → Name & Email
		out.println("<div class='row mb-3'>");

		out.println("<div class='col-md-6'>");
		out.println("<label class='form-label'>Name</label>");
		out.println("<input type='text' class='form-control' name='name' placeholder='Enter Name'>");
		out.println("</div>");

		out.println("<div class='col-md-6'>");
		out.println("<label class='form-label'>Email</label>");
		out.println("<input type='email' class='form-control' name='email' placeholder='Enter Email'>");
		out.println("</div>");

		out.println("</div>");

		// Row 2 → Contact & Salary
		out.println("<div class='row mb-3'>");

		out.println("<div class='col-md-6'>");
		out.println("<label class='form-label'>Contact</label>");
		out.println("<input type='text' class='form-control' name='contact' placeholder='Enter Contact Number'>");
		out.println("</div>");

		out.println("<div class='col-md-6'>");
		out.println("<label class='form-label'>Salary</label>");
		out.println("<input type='text' class='form-control' name='salary' placeholder='Enter Salary'>");
		out.println("</div>");

		out.println("</div>");

		// Row 3 → Department
		out.println("<div class='row mb-4'>");

		out.println("<div class='col-md-12'>");
		out.println("<label class='form-label'>Department</label>");
		out.println("<select name='deptId' class='form-control'>");
		out.println("<option selected disabled>Select Department</option>");

		List<DepartmentModel> deptList = emplService.getDeptsForEmployee();

		for (DepartmentModel model : deptList) {
			out.println("<option value='" + model.getDid() + "'>" + model.getDname() + "</option>");
		}

		out.println("</select>");
		out.println("</div>");

		out.println("</div>");

		// Button
		out.println("<div class='text-center'>");
		out.println("<button type='submit' name='s' class='btn btn-primary px-5'>Add Employee</button>");
		out.println("</div>");

		out.println("</div>"); // card
		out.println("</div>"); // col
		out.println("</div>"); // row
		out.println("</div>"); // container

		out.println("</form>");

		String btn = request.getParameter("s");

		if (btn != null) {
			String Ename = request.getParameter("name");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			int salary = Integer.parseInt(request.getParameter("salary").trim());
			int deptId = Integer.parseInt(request.getParameter("deptId").trim());

			EmployeeModel model = new EmployeeModel(0,Ename,email,salary,contact,deptId);
			Boolean result = emplService.addEmployee(model);

			if (result) {
				out.println(
						"<html><body><script>" + "alert('Employee Added Successfully....!');</script></body></html>");
			} else {

				out.println("<html><body><script>"
						+ "alert('Something Went Wrong....?'); window.location = 'dashboard.html'</script></body></html>");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
