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

import com.MVCProject.model.DepartmentModel;
import com.MVCProject.model.EmployeeModel;
import com.MVCProject.service.DepartmentService;
import com.MVCProject.service.DepartmentServiceImpl;
import com.MVCProject.service.EmployeeService;
import com.MVCProject.service.EmployeeServiceImp;
 
@WebServlet("/viewemployee")
public class ViewEmployeeControl extends HttpServlet {protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.html");
	requestDispatcher.include(request, response);
	out.println("<h1 class='text-center'>View All Employees</h1>");
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
	out.println("<th>EMPLOYEE NAME</th>");
	out.println("<th>EMAIL</th>");
	out.println("<th>EMPLOYEE CONTACT</th>");	
	out.println("<th>DEPARTMENT NAME</th>");
	out.println("<th>UPDATE</th>");
	out.println("<th>DELETE</th>");		
	out.println("</tr>");
	out.println("</thead>");

	// Table body
	out.println("<tbody>");
	EmployeeService empService = new EmployeeServiceImp();
	List<Object[]> list = empService.getAllEmployeeWithDepartment();
	int count = 0;
	for(Object obj[]:list)
	{
		++count;
		out.println("<td>"+count+"</td>");
		out.println("<td>"+obj[0]+"</td>");
		out.println("<td>"+obj[1]+"</td>");
		out.println("<td>"+obj[1]+"</td>");	
		out.println("<td>"+obj[2]+"</td>");
		out.println("<td> <a  class='text-warning'><i class='bi bi-pencil-square'></i></a></td>");
		out.println("<td><a class='text-danger'><i class='bi bi-trash'></i></a></td>");	
	}
	out.println("</tbody>");
	out.println("</table>");
	out.println("</div>");

	} protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
