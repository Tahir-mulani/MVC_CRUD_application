package com.MVCProject.repository;

import java.sql.*;

import com.MVCProject.model.UserModel;

public class RegisterUserRepositoryImpl extends DBConnection implements RegisterUserRepository{

	@Override
	public boolean isRegisteredUser(UserModel model) {
		
		try {
			p = con.prepareStatement("insert into Register values('0',?,?,?,?,?)");
			p.setString(1, model.getName());
			p.setString(2, model.getEmail());
			p.setString(3, model.getContact());
			p.setString(4, model.getUsername());
			p.setString(5, model.getPassword());
			return p.executeUpdate() > 0 ? true : false;

		} catch (SQLException ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

}
