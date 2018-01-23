package com.UserDaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.UserDao;
import com.config.HibernateConfig;
import com.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	private HibernateConfig config;

	public boolean insertUser(User user) {
		config = new HibernateConfig();

		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return true;
	}

//	public List<User> getAllUsers() {
//		List<User> userList = new ArrayList<User>();
//		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
//		userList = session.createQuery("FROM user_info").list();
//		return userList;
//	}

}
