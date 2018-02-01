package com.VumanBackend.Supplier;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.SupplierDao;
import com.DaoImpl.SupplierDaoImpl;
import com.config.HibernateConfig;
import com.model.Supplier;

public class TestInsertSupplier {
	
	private static SupplierDao supplierDao;
	private static HibernateConfig config;
	
	@BeforeClass
	public static void setUp(){
		config = new HibernateConfig();
		supplierDao = new SupplierDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	@Test
	public void testInsertSupplier(){
		Supplier supplier = new Supplier();
		supplier.setSid("1");
		supplier.setSupplierName("Supp 1");
		supplierDao.insertSupplier(supplier);
	}
	

}
