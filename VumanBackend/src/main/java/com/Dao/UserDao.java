package com.Dao;

import com.model.User;
import java.util.List;
public interface UserDao {
	//List<User> getAllUsers();
	boolean save(User user);
}

