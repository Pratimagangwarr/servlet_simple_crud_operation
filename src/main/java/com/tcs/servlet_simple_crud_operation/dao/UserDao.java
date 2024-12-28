package com.tcs.servlet_simple_crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tcs.servlet_simple_crud_operation.connection.UserConnection;
import com.tcs.servlet_simple_crud_operation.dto.User;


public class UserDao {
	
	Connection connection = UserConnection.getUserConnection();
	final String INSERTUSERQUERY ="INSERT INTO USER1(id, name, email, dob, gender, password) values(?,?,?,?,?,?)";
	final String USEREMAILQUERY = "SELECT * FROM USER1 WHERE email=?";
	final String DISPLAYALLUSER ="SELECT * FROM USER1";
	final String dELETEUSERBYIDQUERY = "DELETE FROM USER1 WHERE id=?";
	
	public User saveUserDao(User user1) {
		try {
			PreparedStatement ps = connection.prepareStatement(INSERTUSERQUERY);
			ps.setInt(1, user1.getId());
			ps.setString(2, user1.getName());
			ps.setString(3, user1.getEmail());
			ps.setObject(4, user1.getDob());
			ps.setString(5, user1.getGender());
			ps.setString(6, user1.getPassword());
			
			int a = ps.executeUpdate();
			String msg = a!=0? "DATA_STORED":"Please Check Your Code";
			System.out.println(msg);
			return user1;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return null;
			
		}
	}
	public User getUserByUserEmailDao(String userEmail) {
		try {
			PreparedStatement ps = connection.prepareStatement(USEREMAILQUERY);
			ps.setString(1, userEmail);
			
			ResultSet resultSet=ps.executeQuery();
			if(resultSet.next()) {
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				
				return new User( email,  password);
			}
			else {
				return null;
			}
			
		
		}catch (SQLException  e) {
			e.printStackTrace();
			
			
			
		}
		return null;
		
	}


public List<User> getAllUserDao(){
	try {
		PreparedStatement ps = connection.prepareStatement(DISPLAYALLUSER);
		
		
		ResultSet resultSet=ps.executeQuery();
		List<User> users = new ArrayList<User>();
		while(resultSet.next()) {
			
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			LocalDate dob = resultSet.getDate("dob").toLocalDate();
			String gender = resultSet.getString("gender");
			
			 User user1 = new User(id, name, email, dob, gender);
			users.add(user1);
		}
	
			return users;
		
			
		
	
	}catch (SQLException  e) {
		e.printStackTrace();
		
	
	return null;
	
}
}


public int deleteUserByIdDao(int userId) {
	
	try {
		PreparedStatement ps = connection.prepareStatement(dELETEUSERBYIDQUERY);
		
		
		ps.setInt(1, userId);
		
		return ps.executeUpdate();
	
	}catch (SQLException  e) {
		e.printStackTrace();
		
		
		
	
	return 0;
	
	}	

}
}