package com.MVCProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
	private int userId;
	private String name;
	private String email;
	private String contact;
	private String username;
	private String password;
	

}
