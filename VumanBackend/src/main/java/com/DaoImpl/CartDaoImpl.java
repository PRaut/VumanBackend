package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.CartDao;
import com.model.Cart;

@Repository("cartDao")
@Service
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;

	public CartDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateCart(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(cart);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteCart(int cartId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Cart cart = session.get(Cart.class, cartId);
		session.delete(cart);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Cart getCartById(int cartId, String userEmail) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Cart> query = session.createQuery("FROM cart WHERE email= :email AND cartId = :cartId");
		query.setParameter("email", userEmail);
		query.setParameter("cartId", cartId);

		Cart cart = query.getSingleResult();
		session.close();
		return cart;
	}

	@Override
	public List<Cart> findCartById(int user_id) {
		System.out.println("in findCartById " + user_id);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Cart> query = session.createQuery("FROM Cart WHERE user_id= :user_id");
		query.setParameter("user_id", user_id);
		List<Cart> cartList = query.list();

		System.out.println("Cart Lines : "+cartList.size());
		session.close();
		return cartList;
	}

	
	public Cart getCartByProductId(int productId){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Cart where cartProductId=:productId");
		query.setParameter("productId", productId);
		Cart cart =  (Cart) query.getSingleResult();
		return cart;
	}
}