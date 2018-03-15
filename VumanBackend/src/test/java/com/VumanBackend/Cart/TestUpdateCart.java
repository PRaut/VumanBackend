package com.VumanBackend.Cart;

import org.hibernate.Session;
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
import com.model.User;

public class TestUpdateCart {
	private static CartDao cartDao;
	private static HibernateConfig config;
	private static UserDao userDao;
	@Autowired
	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		cartDao = new CartDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}

	@Test
	public void testUpdateCart() {
		userDao = new UserDaoImpl(config.getSessionFactory(config.getH2DataSource()));
		User user = userDao.getUser(1);
		/*Session session= sessionFactory.getCurrentSession();
		session.beginTransaction();*/
		Cart cart =new Cart();
		cart.setCartId(169);
		cart.setCartImage("Dress1.jpg");
		cart.setCartPrice(2400);
		cart.setCartProductId(35);
		cart.setCartProductName("Dress");
		cart.setCartQty(1);
		cart.setUser(user);
		System.out.println("Cart ID: "+cart.getCartId());
		cartDao.updateCart(cart);
	}
}
