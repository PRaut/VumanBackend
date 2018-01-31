package com.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.UserDao;
import com.config.HibernateConfig;
import com.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	private HibernateConfig config;
	
	@Autowired
	SessionFactory sessinFactory;


//	 public boolean insertUser(User user) {
//	 config = new HibernateConfig();
//	
//	 Session session =
//	 config.getSessionFactory(config.getH2DataSource()).openSession();
//	 session.beginTransaction();
//	 session.save(user);
//	 session.getTransaction().commit();
//	 session.close();
//		 
//	 return true;
//	 }
	 
	
	@Autowired
	public UserDaoImpl(SessionFactory sessinFactory) {
		super();
		this.sessinFactory = sessinFactory;
	}

	@Transactional
	public void insertUser(User user) {
		Session session = sessinFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
	}

	
//	public void updateUser(User user) {
//		config = new HibernateConfig();
//		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
//		session.beginTransaction();
//
//		session.update(user);
//
//		session.getTransaction().commit();
//		session.close();
//
//	}
//
//	public void deleteUser(User user) {
//		config = new HibernateConfig();
//		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
//		session.beginTransaction();
//		session.delete(user);
//		session.getTransaction().commit();
//		session.close();
//	}
//
//	public List<User> getAllUsers() {
//		config = new HibernateConfig();
//		List<User> userList = new ArrayList<User>();
//		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
//		session.beginTransaction();
//		Query<User> query = session.createQuery("FROM User"); // this is
//																// Hibernate
//																// Query lang.
//																// and 'User' is
//																// Entity name
//																// not a Table
//		userList = query.list();
//		session.getTransaction().commit();
//		session.close();
//		return userList;
//	}
//
//	public User getUser(int id) {
//		config = new HibernateConfig();
//		Session session = config.getSessionFactory(config.getH2DataSource()).openSession();
//		session.beginTransaction();
//		User user = (User) session.get(User.class, id);
//		session.getTransaction().commit();
//		session.close();
//		return user;
//	}

}
