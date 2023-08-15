package com.nykaa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.nykaa.util.Queries;

public class DBConnection {
	static Connection connection;
	public static Connection openConnection()  {
		String url="jdbc:mysql://localhost:3306/mysql";
		String username="root";
		String password="admin@123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, username, password);
//			Statement statement=connection.createStatement();
//			statement.execute(Queries.CREATEQUERY);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
