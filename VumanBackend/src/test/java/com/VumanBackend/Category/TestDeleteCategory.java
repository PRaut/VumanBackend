package com.VumanBackend.Category;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.Dao.CategoryDao;
import com.DaoImpl.CategoryDaoImpl;
import com.config.HibernateConfig;
import com.model.Category;

public class TestDeleteCategory {
	private static HibernateConfig config;
	private static CategoryDao categoryDao;

	@Ignore
	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		//categoryDao = new CategoryDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	@Ignore
	@Test
	public void testDeleteCategory(){
		Category category = new Category();
		category.setCid("1");
		//categoryDao.deleteCategory(category);
	}
}
