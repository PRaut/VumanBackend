package com.VumanBackend.Category;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.CategoryDao;
import com.DaoImpl.CategoryDaoImpl;
import com.config.HibernateConfig;
import com.model.Category;

public class TestGetAllCategories {
	private static HibernateConfig config;
	private static CategoryDao categoryDao;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		categoryDao = new CategoryDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	@Test
	public void testGetAllCategories(){
		List<Category> categoryList = categoryDao.getAllCategories();
		
		for(Category cat: categoryList){
			System.out.println(cat.getCid()+" "+cat.getCname());
		}
	}
}
