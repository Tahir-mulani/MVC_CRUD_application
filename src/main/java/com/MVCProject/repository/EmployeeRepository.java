package com.MVCProject.repository;

import java.util.List;
import java.util.Optional;

import com.MVCProject.model.DepartmentModel;
import com.MVCProject.model.EmployeeModel;

public interface EmployeeRepository {
	public boolean idAddedEmployee(EmployeeModel model); 
	public List<Object[]> getAllEmployeewithDepartments();
	

}
