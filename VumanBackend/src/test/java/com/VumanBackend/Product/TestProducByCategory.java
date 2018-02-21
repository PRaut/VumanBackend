package com.VumanBackend.Product;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.DaoImpl.ProductDaoImpl;
import com.config.HibernateConfig;
import com.model.Product;

public class TestProducByCategory {

	private static HibernateConfig config;
	private static ProductDaoImpl productDao;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		productDao = new ProductDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}

	@Test
	public void testGetProductsByCategory() {
		List<Product> prodByCatList = productDao.getProductsByCategotry("2");
		for(Product product: prodByCatList){
			System.out.println("Name: "+ product.getProductName()+ " CID: "+ product.getCategory().getCid());
		}
	}
}
