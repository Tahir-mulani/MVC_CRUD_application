package com.MVCProject.service;

import java.util.List;
import java.util.Optional;
import com.MVCProject.model.*;

public interface EmployeeService {

	public boolean addEmployee(EmployeeModel model);
	public Optional<List<DepartmentModel>> getAllDepartmentList(DepartmentService deptService);
	public List<DepartmentModel> getDeptsForEmployee();
	public List<Object[]> getAllEmployeeWithDepartment();
	
	 
	
}
