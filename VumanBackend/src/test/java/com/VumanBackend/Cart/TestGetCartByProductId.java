package com.VumanBackend.Cart;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.Dao.CartDao;
import com.Dao.UserDao;
import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.config.HibernateConfig;
import com.model.Cart;

public class TestGetCartByProductId {
	@Autowired
	private static CartDao cartDao;
	private static HibernateConfig config;
	private static UserDao userDao;

	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		cartDao = new CartDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}

	@Test
	public void testGetCartByID(){
		userDao = new UserDaoImpl(config.getSessionFactory(config.getH2DataSource())) ;
		cartDao = new CartDaoImpl(config.getSessionFactory(config.getH2DataSource()));
		Cart cart = cartDao.getCartByProductId(36);
		assertEquals("Failed Get Cart By Product ID", 267, cart.getCartId());
	}
}
