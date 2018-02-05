package com.VumanBackend.User;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.config.HibernateConfig;
import com.model.User;

public class TestGetUserById {

	private static UserDao userDao;
	private static HibernateConfig config;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		userDao = new UserDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	 @Test
	 public void testGetUser() {
	 User user = (User) userDao.getUser(new Integer(54));
	 System.out.println("ID: " + user.getId() + ", Name: " + user.getName());
	 }
}
