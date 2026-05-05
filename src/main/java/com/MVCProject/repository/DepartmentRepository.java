package com.MVCProject.repository;

import java.util.List;
import java.util.Optional;

import com.MVCProject.model.DepartmentModel;

public interface DepartmentRepository {
	public boolean isAddedDepartment(DepartmentModel model);
	public Optional<List<DepartmentModel>> getAllDepartments();
	public boolean idDeletedDepartment(int id);
}
