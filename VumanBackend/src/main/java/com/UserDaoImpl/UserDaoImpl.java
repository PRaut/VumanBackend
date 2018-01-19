package com.UserDaoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Dao.UserDao;
import com.model.User;

//@Repository("userDao")
//@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public UserDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}


	public boolean save(User user) {
		try {
			//sessionFactory.getCurrentSession().save(user);
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 session.save(user);
		 session.getTransaction().commit();
		 session.close();
		 sessionFactory.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// public List<User> userlist() {
	//
	// return sessionFactory.getCurrentSession().createQuery("from
	// User").list();
	// }

	// public List<User> getAllUsers() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
