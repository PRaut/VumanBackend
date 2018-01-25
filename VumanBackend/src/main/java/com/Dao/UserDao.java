package com.Dao;

import com.model.User;
import java.util.List;

public interface UserDao {
	boolean insertUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	User getUser(int id);

	List<User> getAllUsers();
}
