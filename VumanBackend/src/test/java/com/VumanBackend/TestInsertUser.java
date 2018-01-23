package com.VumanBackend;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.UserDao;
import com.UserDaoImpl.UserDaoImpl;
import com.config.HibernateConfig;
import com.model.User;

public class TestInsertUser {

	private static UserDao userDao;
	//private HibernateConfig config;
	//private Session session;
	
	@BeforeClass
	public static void setUp(){
		userDao = new UserDaoImpl();
		//config = new HibernateConfig();
		//session = config.getSessionFactory(config.getH2DataSource()).openSession();
	}
	
	@Test
	public void testInsertUser(){
		User user = new User();
		user.setName("test2");
		user.setPassword("123456");
		user.setPhone("98968635");
		user.setAddress("TestAddress2");
		user.setEmail("test2@gmail.com");
		user.setJoinDate(new Date());
		
		assertTrue(userDao.insertUser(user));
	}

}

