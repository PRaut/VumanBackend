package com.VumanBackend.Cart;

import static org.junit.Assert.*;

import java.util.List;

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

public class TestGetCartByID {
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
		
		User user = userDao.getUser(1);
		System.out.println("in test findCart "+ user.getId());
		
		List<Cart> listCart = cartDao.findCartById(user.getId());
		
		/*for(Cart cart:listCart){
			System.out.println(cart.getCartId()+ " "+cart.getCartProductName());
		}*/
		
		assertEquals("getCart failed", 6, listCart.size());
}
}
