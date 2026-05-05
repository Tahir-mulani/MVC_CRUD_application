package com.MVCProject.repository;

import java.sql.SQLException;

import com.MVCProject.model.EmployeeModel;

public class EmployeeRepositoryImp extends DBConnection implements EmployeeRepository{

	@Override
	public boolean idAddedEmployee(EmployeeModel model) {
		try {
			p = con.prepareStatement("insert into Employee values('0',?,?,?,?)");
			p.setString(1, model.getName());
			p.setInt(2, 1);
			p.setString(3,model.getContact());
			p.setInt(4, model.getSalary());
			return  p.executeUpdate()>0? true:false;
			
			
		}
		catch(SQLException ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
	}


}
