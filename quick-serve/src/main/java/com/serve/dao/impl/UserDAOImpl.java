package com.serve.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.serve.connection.MyConnection;
import com.serve.dao.LoginDAO;
import com.serve.models.UserModel;

public class UserDAOImpl implements LoginDAO {
	private Connection con = null;
	private PreparedStatement pstm = null;
	private ResultSet result;
	private Statement statement;

	@Override
	public boolean add(UserModel users) {
		UserModel user = getUser(users);
		con = MyConnection.getConnection();
		
		if(con == null) {
			return false;
		}
		
		String query = "INSERT INTO user(full_name,email,password,phonenumber,las_log_date,reg_date) VALUES(?,?,?,?,?,NOW())";
		
			pstm = MyConnection.getPrepareStatement(query, con);
			try {
				//filling all the date witch is query for query
				pstm.setString(1, user.getfName());
				pstm.setString(2, user.getEmail());
				pstm.setString(3, user.getPassword());
				pstm.setString(4, user.getPhonenumber());
				pstm.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
				
				//get how many row affected 
				int re = pstm.executeUpdate();
				
				//return re == 1 then true other wise false
				return re == 1 ? true : false;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
					//closing connection and prepared statement
						MyConnection.closeConnection(con, pstm);
			}
			
				
		return false;
	}

	@Override
	public boolean update(UserModel users) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserModel tbale) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public UserModel fetch(UserModel users) {
		UserModel user = getUser(users);
		String query = "SELECT * FROM user WHERE email = ?";
		
		con = MyConnection.getConnection();
		pstm = MyConnection.getPrepareStatement(query, con);
		try {
			pstm.setString(1, user.getEmail());
			result = pstm.executeQuery();
			result.next();
			String password = result.getString("password");
			
			if(user.getPassword().equals(password)) {
				
				user.setfName(result.getString("full_name"));
				user.setId(result.getInt("id"));
				
				updateLoginDate(user.getEmail());
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MyConnection.closeConnection(con, pstm);
		}
		return null;
		
	}

	private void updateLoginDate(String email) {
		String query1 = "UPDATE user SET las_log_date = now() WHERE email = ?";
		pstm = MyConnection.getPrepareStatement(query1, con);
		try {
			pstm.setString(1, email);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MyConnection.closeConnection(con, pstm);
		}
		
		
	}
	
	private UserModel getUser(UserModel users) {
		
		return (UserModel) users;
	}
	
}
