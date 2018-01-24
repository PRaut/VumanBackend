package com.Dao;

import com.model.User;
import java.util.List;

public interface UserDao {
	boolean insertUser(User user);

	List<User> getAllUsers();

	User getUser(int id);
}
