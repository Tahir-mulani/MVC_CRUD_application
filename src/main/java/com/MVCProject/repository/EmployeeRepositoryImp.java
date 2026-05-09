package com.MVCProject.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.*;
import com.MVCProject.model.EmployeeModel;
import com.mysql.cj.exceptions.CJConnectionFeatureNotAvailableException;

public class EmployeeRepositoryImp extends DBConnection implements EmployeeRepository {
	private List<Object[]> list;

	@Override
	public boolean idAddedEmployee(EmployeeModel model) {
		try {
			p = con.prepareStatement("insert into Employee values('0',?,?,?,?,?)");
			p.setString(1, model.getName());
			p.setString(2, model.getEmail());
			p.setInt(3, model.getDeptid());
			p.setString(4, model.getContact());
			p.setInt(5, model.getSalary());
			return p.executeUpdate() > 0 ? true : false;

		} catch (SQLException ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

	@Override
	public List<Object[]> getAllEmployeewithDepartments() {

		try {
			list = new ArrayList<Object[]>();
			p = con.prepareStatement(
					"select e.name,e.email,e.contact,e.salary,d.dname AS department_name from employee e join department d on e.deptid = d.did");
			rs = p.executeQuery();

			while (rs.next()) {
				list.add(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getString(5) });
			}
			return list;
		} catch (Exception e) {

			System.out.println("Error is " + e);
			return null;
		}
	}

	@Override
	public boolean idDeletedEmployee(int id) {
		try {
			p = con.prepareStatement("delete from  Employee where eid =?");
			p.setInt(1,id);
			return p.executeUpdate() > 0 ? true : false;

		} catch (SQLException ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

}
