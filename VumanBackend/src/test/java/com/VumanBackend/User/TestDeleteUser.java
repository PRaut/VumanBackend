package com.VumanBackend.User;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.config.HibernateConfig;
import com.model.User;

public class TestDeleteUser {

	private static UserDao userDao;
	private static HibernateConfig config;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		userDao = new UserDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}

	@Test
	public void testDeleteUser() {
		// Session session = config.getSessionFactory(config.getH2DataSource())
		// .openSession();
		// session.beginTransaction();
		// User user = session.get(User.class,7);
		User user = new User();
		user.setId(17);

		//userDao.deleteUser(user);

	}
}
