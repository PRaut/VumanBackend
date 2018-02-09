package com.VumanBackend.User;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.config.HibernateConfig;
import com.model.User;

public class TestInsertUser {

	private static UserDao userDao;
	//private static SessionFactory sessionFactory;
	private  static HibernateConfig config;
	//private Session session;
	
	@BeforeClass
	public static void setUp(){
		config = new HibernateConfig();
		userDao = new UserDaoImpl(config.getSessionFactory(config.getH2DataSource()));
		//config = new HibernateConfig();
		//session = config.getSessionFactory(config.getH2DataSource()).openSession();
	}
	
	@Test
	public void testInsertUser(){
		User user = new User();
		user.setName("test3");
		user.setPassword("123456");
		user.setPhone("98968635");
		user.setAddress("TestAddress2");
		user.setEmail("test2@gmail.com");
		user.setJoinDate(new Date());
		
		//assertTrue(userDao.insertUser(user));
		//userDao.insertUser(user);
	}

}

