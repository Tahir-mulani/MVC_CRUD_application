package com.MVCProject.service;

import java.util.List;
import java.util.Optional;

import com.MVCProject.model.DepartmentModel;
import com.MVCProject.repository.DepartmentRepositorymp;

public class DepartmentServiceImpl implements DepartmentService{
	DepartmentRepositorymp addDepartmentRepoImp = new DepartmentRepositorymp();
	@Override
	public boolean addDepartmentService(DepartmentModel model) {
		return addDepartmentRepoImp.isAddedDepartment(model);
	}
	@Override
	public Optional<List<DepartmentModel>> getAllDepts() {
		// TODO Auto-generated method stub
		return addDepartmentRepoImp.getAllDepartments();
	}
	@Override
	public boolean deleteDepartmentService(int id) {
		// TODO Auto-generated method stub
		return addDepartmentRepoImp.idDeletedDepartment(id);
	}
}
