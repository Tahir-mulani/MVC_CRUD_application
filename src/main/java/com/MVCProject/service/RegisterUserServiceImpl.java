package com.MVCProject.service;

import com.MVCProject.model.UserModel;
import com.MVCProject.repository.RegisterUserRepositoryImpl;

public class RegisterUserServiceImpl implements RegisterUserService{
	RegisterUserRepositoryImpl registerUser = new RegisterUserRepositoryImpl();
	@Override
	public boolean registerUser(UserModel model) {
		 
		return registerUser.isRegisteredUser(model);
	}

}
