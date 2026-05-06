package com.MVCProject.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.modelmbean.ModelMBean;

import com.MVCProject.model.DepartmentModel;

public class DepartmentRepositorymp extends DBConnection implements DepartmentRepository {
	List<DepartmentModel> deptList;

	@Override
	public boolean isAddedDepartment(DepartmentModel model) {

		try {
			p = con.prepareStatement("insert into department values(0,?)");
			p.setString(1, model.getDname());
			return p.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			System.out.println("error is " + e);
			return false;
		}

	}

	@Override
	public Optional<List<DepartmentModel>> getAllDepartments() {
		try {
			deptList = new ArrayList<>();
			p = con.prepareStatement("select*from department");
			rs = p.executeQuery();
			while (rs.next()) {
				DepartmentModel dModel = new DepartmentModel();
				dModel.setDid(rs.getInt(1));
				dModel.setDname(rs.getString(2));
				deptList.add(dModel);
			}
			return Optional.ofNullable(deptList);
		} catch (Exception e) {
			System.out.println("Error is "+e);
			return null;
		}
		 
	}

	@Override
	public boolean idDeletedDepartment(int id) {
		try {
			p = con.prepareStatement("delete from department where did =?");
			p.setInt(1, id);
			return p.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			System.out.println("error is " + e);
			return false;
		}

		
	}

	@Override
	public boolean idUpdatedDepartment(DepartmentModel model) {
		try {
			p = con.prepareStatement("update department SET dname=? where did=?");
			p.setString(1,model.getDname());
			p.setInt(2,model.getDid());
			return p.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			System.out.println("error is " + e);
			return false;
		}
	}

}
