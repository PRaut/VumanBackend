package com.VumanBackend.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.config.HibernateConfig;
import com.model.User;

public class TestUpdateUser {

	private static UserDao userDao;
//	private static SessionFactory sessionFactory;
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
	public void testUpdateUser(){
//		Session session = config.getSessionFactory(config.getH2DataSource())
//				.openSession();
//		session.beginTransaction();
//		User user = session.get(User.class, 8); 
		User user = new User();
		user.setId(54);
		user.setName("Vina");
		user.setEmail("vina@gmail.com");
		user.setAddress("nag");
		
		userDao.updateUser(user);
	}
	
}
