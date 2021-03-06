
package com.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.ProductDao;
import com.model.Product;

@Repository("productDao")
@Service
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public ProductDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		System.out.println("4> in prDaoImpl const.");
	}
	

	//@Transactional
	public void insertProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
		session.close();
	}
	
	//@Transactional
	public void updateProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		session.close();
		
	}

	//@Transactional
	public void deleteProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(product);
		session.getTransaction().commit();
		session.close();
	}

	//@Transactional
	public Product getProduct(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = session.get(Product.class, id);
		session.getTransaction().commit();
		session.close();
		return product;
	}

	//@Transactional
	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query =  session.createQuery("FROM Product");
		List<Product> productsList = query.list();
		return productsList;
	}
	
	public List<Product> getProductsByCategotry(String cid){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Product WHERE cid= :cid");
		query.setString("cid",cid);
		List<Product> productByCategoryList = query.list();
		return productByCategoryList;
	}

}
