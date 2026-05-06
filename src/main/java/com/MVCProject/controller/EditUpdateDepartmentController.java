package com.MVCProject.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import com.MVCProject.model.DepartmentModel;
import com.MVCProject.service.DepartmentService;
import com.MVCProject.service.DepartmentServiceImpl;

/**
 * Servlet implementation class EditUpdateDepartmentController
 */
@WebServlet("/editupdatedepartment")
public class EditUpdateDepartmentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String dname = request.getParameter("deptname");
		Optional<String> op = Optional.ofNullable(dname);
		Optional<Integer> o = Optional.empty();
		try {
			o = Optional.of(Integer.parseInt(request.getParameter("deptid")));

		} catch (NumberFormatException e) {
			System.out.println("Error is " + e);
		}

		if (!op.isEmpty() && op.get() != null) {
			DepartmentModel model = new DepartmentModel();
			model.setDid(o.get());
			model.setDname(dname);
			DepartmentService updateService = new DepartmentServiceImpl();
			boolean result = updateService.updateDepartmentService(model);
			if (result) {
				out.println("<html><body><script>" + "alert('Department Updated Successfully....!');"
						+ "window.location = 'dashboard.html';" + "</script></body></html>");
			} else {
				out.println("<html><body><script>" + "alert('Some Went Wrong....?'); "

						+ "window.location = 'dashboard.html'</script></body></html>");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
