package com.VumanBackend.User;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.config.HibernateConfig;
import com.model.User;

public class TestGetAllUsers {

	private static UserDao userDao;
	private static HibernateConfig config;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		userDao = new UserDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}

	@Test
	public void testGetAllUsersList() {
		List<User> usersList = new ArrayList<User>();
		usersList = userDao.getAllUsers();
		if (usersList.isEmpty()) {
			System.out.println("No records found");
		} else {
			for (User user : usersList) {
				System.out.println("Name: " + user.getName() + ", Address: " + user.getAddress());
			}
		}

	}
}
