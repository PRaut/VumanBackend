package com.VumanBackend;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.UserDao;
import com.UserDaoImpl.UserDaoImpl;
import com.config.HibernateConfig;
import com.model.User;

public class TestDeleteUser {

	private static UserDao userDao;
	private static HibernateConfig config;
	
	@BeforeClass
	public static void setUp(){
		userDao = new UserDaoImpl();
		config = new HibernateConfig();
	}
	
	@Test
	public void testDeleteUser(){
		Session session = config.getSessionFactory(config.getH2DataSource())
				.openSession();
		session.beginTransaction();
		User user = session.get(User.class,7); 
		
		userDao.deleteUser(user);
		
	}
}

