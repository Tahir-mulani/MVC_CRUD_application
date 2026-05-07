package com.MVCProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel{
private int id;
private String name;
private String email;
private int salary;
private String contact;
private int deptid; 
}
