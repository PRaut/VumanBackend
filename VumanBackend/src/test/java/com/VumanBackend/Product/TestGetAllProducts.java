package com.VumanBackend.Product;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.DaoImpl.ProductDaoImpl;
import com.config.HibernateConfig;
import com.model.Product;

public class TestGetAllProducts {
	private static HibernateConfig config;
	private static ProductDaoImpl productDao;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		productDao = new ProductDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}

	@Test
	public void testGetAllProducts() {
		List<Product> productsList = productDao.getAllProducts();

		for (Product product : productsList) {
			System.out.println(product.getPid() + " " + product.getProductName());
		}
	}
}
