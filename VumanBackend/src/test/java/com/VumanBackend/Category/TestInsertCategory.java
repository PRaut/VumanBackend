package com.VumanBackend.Category;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.CategoryDao;
import com.DaoImpl.CategoryDaoImpl;
import com.config.HibernateConfig;
import com.model.Category;

public class TestInsertCategory {
	
	private static HibernateConfig config;
	private static CategoryDao categoryDao;
	
	@BeforeClass
	public static void setUp(){
		config = new HibernateConfig();
		categoryDao = new CategoryDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	@Test
	public void testInsertCategory(){
		Category category  = new Category();
		category.setCid("1");
		category.setCname("Sarees");
		
		//categoryDao.insertCategory(category);
	}
}
