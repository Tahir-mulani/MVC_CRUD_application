package com.MVCProject.repository;
import java.sql.*;
public class DBConnection {
	protected PreparedStatement p;
	protected Connection con;
	protected ResultSet rs;
	
	public DBConnection() {
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/CRUD_APP",
				 "root",
				 "7083560700"
				); 
		}
		catch(Exception e)
		{
			System.out.println("Connection failed"); 
			e.printStackTrace();
		}
	}
}
