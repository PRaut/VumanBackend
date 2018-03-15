package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Cart;
import com.model.Category;
import com.model.Orders;
import com.model.Product;
import com.model.Supplier;
import com.model.User;

@Configuration
@ComponentScan(basePackages = { "com" })
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean(name = "datasource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("Accessing Hibernate Config datasource");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");  // change to update after all complete
		System.out.println("Hibernate Properties created");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		System.out.println("Session object Created");
		sessionBuilder.addProperties(getHibernateProperties());
		System.out.println("Properties added");
		
		sessionBuilder.scanPackages("com.Model");
		System.out.println("Scan base package \' com.Model\'");
		
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(Orders.class);
		
		System.out.println("User class added");
		return sessionBuilder.buildSessionFactory();
	}
		
	@Autowired
	@Bean(name = ("transactionManager"))
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
	
	
	// Required Beans
	@Autowired
	@Bean(name="supplierDaoImpl")
	public SupplierDaoImpl getSuppData(SessionFactory sf){
		System.out.println("1> in suppDaoImpl config");
		return new SupplierDaoImpl(sf);
	}

	@Autowired
	@Bean(name="categoryDaoImpl")
	public CategoryDaoImpl getCategoryData(SessionFactory sf){
		System.out.println("2> in catDaoImpl config");
		return new CategoryDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="userDaoImpl")
	public UserDaoImpl getUserData(SessionFactory sf){
		System.out.println("3> in userDaoImpl config");
		return new UserDaoImpl(sf); 
	}
	
	@Autowired
	@Bean(name="productDaoImpl")
	public ProductDaoImpl getProductData(SessionFactory sf){
		System.out.println("4> in prdDaoImpl config");
		return new ProductDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="cartDaoImpl")
	public CartDaoImpl getCartData(SessionFactory sf){
		System.out.println("5> in cartDaoImpl config");
		return new CartDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="ordersDaoImpl")
	public OrdersDaoImpl getOrdersData(SessionFactory sf){
		System.out.println("6> in ordersDaoImpl config");
		return new OrdersDaoImpl(sf);
	}

}
