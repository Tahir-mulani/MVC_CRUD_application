package com.MVCProject.service;

import com.MVCProject.model.EmployeeModel;
import com.MVCProject.repository.EmployeeRepositoryImp;

public class EmployeeServiceImp implements EmployeeService{
	EmployeeRepositoryImp addEmployeeRepoImp = new EmployeeRepositoryImp();
	@Override
	public boolean addEmployee(EmployeeModel model) {
		 if(model == null)
		 {
			 return false;
		 }
		return addEmployeeRepoImp.idAddedEmployee(model);
	}

}
