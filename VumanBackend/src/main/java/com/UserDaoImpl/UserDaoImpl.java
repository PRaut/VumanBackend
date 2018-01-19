package com.UserDaoImpl;

import java.util.ArrayList;
import java.util.List;

import com.Dao.UserDao;
import com.model.User;

public class UserDaoImpl implements UserDao{

	List<User> users;
	// This list is a subsitute for database
	   public UserDaoImpl(){
	      users = new ArrayList<User>();
	      User user1 = new User("Robert@gmail.com");
	      User user2 = new User("John@gmail.com");
	      users.add(user1);
	      users.add(user2);		
	   }

	public List<User> getAllUsers() {
		return users;
		
	}

}
