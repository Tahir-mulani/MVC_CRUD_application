package com.MVCProject.controller;

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
import java.util.Optional;

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
		out.println("<h1 class='text-center'>Add New Employee</h1>");
		out.println("<form action='' method='post'>" + "<div class='container mt-5 bg-dark p-5'>" +

				"  <div class='row mb-3'>" + "    <div class='col-md-6'>"
				+ "      <label class='form-label'>Employee Name</label>"
				+ "      <input type='text' class='form-control' name='name' placeholder='Enter Name'>" + "    </div>" +

				"  <div class='col-md-6'>" + "    <label class='form-label'>Department</label>"
				+ "    <select class='form-control' name='deptId'>");
		out.println("<option value=''>-- Select Department --</option>");
		out.println("<option value='1'>HR</option>"
				+ "      <option value='2'>IT</option>" + "      <option value='3'>Finance</option>"
				+ "      <option value='4'>Sales</option>" + "    </select>" + "  </div>");

		out.println("  <div class='row mb-3'>" + "    <div class='col-md-6'>"
				+ "      <label class='form-label'>Contact</label>"
				+ "      <input type='text' class='form-control' value='' name='contact' placeholder='Enter Contact Number'>"
				+ "    </div>" +

				"    <div class='col-md-6'>" + "      <label class='form-label'>Salary</label>"
				+ "      <input type='text' class='form-control' value = '' name='salary' placeholder='Enter Salary'>"
				+ "    </div>" + "  </div>" +

				"  <div class='text-center'>"
				+ "    <button type='submit' name='s' class='btn btn-primary px-4'>Add Employee</button>" + "  </div>" +

				"</div>" + "</form>");
		String name = request.getParameter("name");
		Optional<Integer> salary = Optional.empty();
		String department = request.getParameter("deptId");
		String contact = request.getParameter("contact");
		try {
			 
			salary = Optional.of(Integer.parseInt(request.getParameter("salary")));

			EmployeeModel e = new EmployeeModel();
			e.setName(name);
			e.setContact(contact);
			e.setSalary(salary.orElse(0));
			EmployeeService employee = new EmployeeServiceImp();
			boolean result = employee.addEmployee(e);
			if (result) {
				out.println("<html><body><script>"
						+ "alert('Employee Registered Successfully....!'); </script></body></html>");
			} else {

				out.println("<html><body><script>"
						+ "alert('Some Went Wrong....?'); window.location = 'dashboard.html'</script></body></html>");
			}

		} catch (Exception er) {
			System.out.println("Error is " + er);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
