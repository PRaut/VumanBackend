package com.VumanBackend.Category;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.CategoryDao;
import com.DaoImpl.CategoryDaoImpl;
import com.config.HibernateConfig;
import com.model.Category;

public class TestUpdateCategory {
	private static HibernateConfig config;
	private static CategoryDao categoryDao;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		categoryDao = new CategoryDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	@Test
	public void testUpdateCategory(){
		Category category = new Category();
		category.setCid("1");
		category.setCname("Dress");
		
		categoryDao.updateCategory(category);
		
	}
	
}
