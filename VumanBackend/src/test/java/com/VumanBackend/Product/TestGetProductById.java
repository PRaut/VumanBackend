package com.VumanBackend.Product;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.DaoImpl.ProductDaoImpl;
import com.config.HibernateConfig;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

import junit.framework.Assert;

public class TestGetProductById {
	private static HibernateConfig config;
	private static ProductDaoImpl productDao;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		productDao = new ProductDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}

	@Test
	public void testGetProductById() {
		// expected product for comparison
		Product product = new Product();
		product.setPid(3);
		product.setProductName("Kurta");
		product.setProductDescription("Authentic Kurta");
		product.setPrice(3000.50f);
		product.setStock(10);

		Category category = new Category();
		category.setCid("1");

		product.setCategory(category);

		Supplier supplier = new Supplier();
		supplier.setSid("1");

		product.setSupplier(supplier);
		product.setImageName("kurta");

		
		// actual product
		Product acProduct = productDao.getProduct(3);
		assertEquals(product.getPid(), acProduct.getPid());
		//System.out.println(acProduct.getPid() + " "+ acProduct.getProductName());

	}

}
