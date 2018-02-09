package com.VumanBackend.Category;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.Dao.CategoryDao;
import com.config.HibernateConfig;
import com.model.Category;

public class TestGetAllCategories {
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
	public void testGetAllCategories(){
		List<Category> categoryList = categoryDao.getAllCategories();
		
		for(Category cat: categoryList){
			System.out.println(cat.getCid()+" "+cat.getCname());
		}
	}
}
