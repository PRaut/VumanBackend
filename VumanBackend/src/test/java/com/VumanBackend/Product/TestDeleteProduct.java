package com.VumanBackend.Product;

import org.junit.BeforeClass;
import org.junit.Test;

import com.DaoImpl.ProductDaoImpl;
import com.config.HibernateConfig;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

public class TestDeleteProduct {
	private static HibernateConfig config;
	private static ProductDaoImpl productDao;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		productDao = new ProductDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}

	@Test
	public void testDeleteProduct() {
		Product product = new Product();
		product.setPid(44);
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

		//productDao.deleteProduct(product);

	}
}
