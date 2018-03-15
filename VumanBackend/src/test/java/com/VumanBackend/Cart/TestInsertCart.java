package com.VumanBackend.Cart;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.CartDao;
import com.Dao.UserDao;
import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.config.HibernateConfig;
import com.model.Cart;
import com.model.User;

public class TestInsertCart {

	private static CartDao cartDao;
	private static HibernateConfig config;
	private static UserDao userDao;


	@BeforeClass
	public static void setUp(){
		config  = new HibernateConfig();
		cartDao = new CartDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	@Test
	public void testInsertCart(){
		userDao = new UserDaoImpl(config.getSessionFactory(config.getH2DataSource())) ; 
		User user = userDao.getUser(1);
		System.out.println(user.getEmail());
		//Cart cart = new Cart(35, 1200.0, 1 , "dress1.jpg", "Dress");
		Cart cart =new Cart();
		cart.setCartImage("Dress1.jpg");
		cart.setCartPrice(1200);
		cart.setCartProductId(35);
		cart.setCartProductName("Dress");
		cart.setCartQty(1);
		cart.setUser(user);
		cartDao.insert(cart);
	}
}

