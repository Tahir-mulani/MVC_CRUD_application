package com.MVCProject.service;

import java.util.List;
import java.util.Optional;

import com.MVCProject.model.DepartmentModel;
import com.MVCProject.repository.DepartmentRepositorymp;

public class DepartmentServiceImpl implements DepartmentService {
	DepartmentRepositorymp departmentRepoImp = new DepartmentRepositorymp();

	@Override
	public boolean addDepartmentService(DepartmentModel model) {
		return departmentRepoImp.isAddedDepartment(model);
	}

	@Override
	public Optional<List<DepartmentModel>> getAllDepts() {

		return departmentRepoImp.getAllDepartments();
	}

	@Override
	public boolean deleteDepartmentService(int id) {

		return departmentRepoImp.idDeletedDepartment(id);
	}

	@Override
	public boolean updateDepartmentService(DepartmentModel model) {
		// TODO Auto-generated method stub
		return departmentRepoImp.idUpdatedDepartment(model);
	}

	 
}
