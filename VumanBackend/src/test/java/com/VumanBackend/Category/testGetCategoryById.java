package com.VumanBackend.Category;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.CategoryDao;
import com.DaoImpl.CategoryDaoImpl;
import com.config.HibernateConfig;
import com.model.Category;

public class testGetCategoryById {
	private static HibernateConfig config;
	private static CategoryDao categoryDao;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		categoryDao = new CategoryDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	@Test
	public void testGetCategoryById(){
		Category category = categoryDao.getCategory("1");
		
		Category expectedCat = new Category();
		expectedCat.setCid("1");
		assertEquals(expectedCat.getCid(), category.getCid());
		System.out.println(category.getCid() +" "+ category.getCname());
	}
}
