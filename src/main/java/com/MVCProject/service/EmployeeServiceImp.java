package com.MVCProject.service;

import java.util.List;
import java.util.Optional;

import com.MVCProject.model.DepartmentModel;
import com.MVCProject.model.EmployeeModel;
import com.MVCProject.repository.EmployeeRepositoryImp;

public class EmployeeServiceImp implements EmployeeService{
	EmployeeRepositoryImp empRepo = new EmployeeRepositoryImp();
	@Override
	public boolean addEmployee(EmployeeModel model) {
		 if(model == null)
		 {
			 return false;
		 }
		return empRepo.idAddedEmployee(model);
	}
	@Override
	public Optional<List<DepartmentModel>> getAllDepartmentList(DepartmentService deptService) {
		 Optional<List<DepartmentModel>> o = deptService.getAllDepts();
		return o;
	}
	@Override
	public List<DepartmentModel> getDeptsForEmployee() {
	 DepartmentService deptService = new DepartmentServiceImpl();
	 Optional<List<DepartmentModel>> o = this.getAllDepartmentList(deptService);
	 return o.get();
	}
	@Override
	public List<Object[]> getAllEmployeeWithDepartment() {
		// TODO Auto-generated method stub
		return empRepo.getAllEmployeewithDepartments();
	}
	 

}
