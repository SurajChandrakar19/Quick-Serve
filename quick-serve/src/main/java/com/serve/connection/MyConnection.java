package com.serve.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/quick_serve";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root";
	
	
	//load mysql driver
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql driver not loaded");
			e.printStackTrace();
		}
	}
	
	//thi is the giving connectin object
	public static Connection getConnection() {
		try {
			System.out.println("connection start");
			return (DriverManager.getConnection(URL,USERNAME,PASSWORD));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection not start");
			return null;
		}
	}
	
	//close the connection
	public static void closeConnection(Connection connection, PreparedStatement preparedStatement) {
		
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		if(connection != null) {
			try {
				connection.close();
				System.out.println("connection close");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
				System.out.println("connection not close");
			}
		}
	}
	
	public static PreparedStatement getPrepareStatement(String query, Connection con) {
		try {
			System.out.println("preparedStatement start");
			return con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("preparedStatement not start");
			return null;
		}
	}
}
