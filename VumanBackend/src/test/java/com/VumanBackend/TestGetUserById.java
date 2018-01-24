package com.VumanBackend;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.UserDao;
import com.UserDaoImpl.UserDaoImpl;
import com.model.User;

public class TestGetUserById {

	private static UserDao userDao;

	@BeforeClass
	public static void setUp() {
		userDao = new UserDaoImpl();
	}

	@Test
	public void testGetUser() {
		User user = (User) userDao.getUser(new Integer(7));
		System.out.println("ID: " + user.getId() + ", Name: " + user.getName());
	}
}
