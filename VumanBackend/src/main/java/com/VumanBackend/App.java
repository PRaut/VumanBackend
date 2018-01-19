package com.VumanBackend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Dao.UserDao;
import com.UserDaoImpl.UserDaoImpl;
import com.model.User;

public class App {
	public static void  main(String [] a) {	
		User user = new User();
		user.setName("John Dow");
		user.setPassword("123");
		user.setPhone("9898789654");
		user.setAddress("Mumbai");
		user.setEmail("john@gmail.com");

		SessionFactory sessionFactory =
				new Configuration().configure().buildSessionFactory();
		//Session session = sessionFactory.openSession();
		//session.beginTransaction();
		
		//session.save(user);
		UserDao userDao = new UserDaoImpl(sessionFactory);
		userDao.save(user);
		
		//session.getTransaction().commit();
		//session.close();
		//sessionFactory.close();
		
	} 
	
}

