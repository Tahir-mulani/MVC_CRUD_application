package com.MVCProject.service;

import java.util.List;
import java.util.Optional;

import com.MVCProject.model.DepartmentModel;

public interface DepartmentService {
	public boolean addDepartmentService(DepartmentModel model);
	public Optional<List<DepartmentModel>> getAllDepts();
	public boolean deleteDepartmentService(int id);
}
