package com.simplilearn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.simplilearn.dto.User;
import com.simplilearn.util.ConnectionManagerImpl;

public class UserDaoImpl implements UserDao{
 private Connection connection;
  public UserDaoImpl() {
	  connection=new ConnectionManagerImpl().getConnection();
  }
	@Override
	public boolean registerUser(User user) {
		boolean isUserRegistered=false;
		String query="insert into users values(?,?,?,?)";
		PreparedStatement statement;
		try {
			  statement=connection.prepareStatement(query);
			  statement.setString(1,user.getFirstname());
			  statement.setString(2,user.getLastname());
			  statement.setString(3,user.getUsername());
			  statement.setString(4,user.getPassword());
			  int rows=statement.executeUpdate(query);
	          if(rows>0) {
	        	  isUserRegistered=true;
	          }
		  } catch (SQLException e) {
			 e.printStackTrace();
		  }
		
		 return isUserRegistered;
	}

}
