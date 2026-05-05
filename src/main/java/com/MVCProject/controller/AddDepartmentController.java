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

import com.MVCProject.model.DepartmentModel;
import com.MVCProject.service.DepartmentService;
import com.MVCProject.service.DepartmentServiceImpl;
 
@WebServlet("/adddepartment")
public class AddDepartmentController extends HttpServlet { 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 RequestDispatcher r = request.getRequestDispatcher("dashboard.html");
		 r.include(request, response);
		 out.println("<h1 class='text-center'>Add New Department</h1>");
		 out.println(
				 "<form action='' method='post'>" +
				 "<div class='container mt-5 bg-dark p-5' >" +

				 "  <div class='row justify-content-center'>" +
				 "    <div class='col-md-6'>" +
				 "      <input type='text' class='form-control mb-3' name='dname' value='' placeholder='Enter Department Name'>" +

				 "      <div class='text-center'>" +
				 "        <button type='submit' name='s' class='btn btn-primary px-4'>Add Department</button>" +
				 "      </div>" +

				 "    </div>" +
				 "  </div>" +

				 "</div>" +
				 "</form>"
				 );
		 String dname = request.getParameter("dname");
		 
		 Optional<String> op = Optional.ofNullable(dname);
		 
		 if(!op.get().equals(null))
		 {
			 DepartmentModel dmodel = new DepartmentModel();
			 
			 dmodel.setDid(0);
			 dmodel.setDname(dname);
			 DepartmentService deptService = new DepartmentServiceImpl();
			 boolean result =deptService.addDepartmentService(dmodel);
			 if (result) {
					out.println("<html><body><script>"
							+ "alert('Department Added Successfully....!');</script></body></html>");
				} else {

					out.println("<html><body><script>"
							+ "alert('Some Went Wrong....?'); window.location = 'dashboard.html'</script></body></html>");
				}
		 }
		 else
		 {
			 out.println("<html><body><script>"
						+ "alert('getting Null value....?'); window.location = 'dashboard.html'</script></body></html>");

		 }
		 
		 
		 
		 
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
