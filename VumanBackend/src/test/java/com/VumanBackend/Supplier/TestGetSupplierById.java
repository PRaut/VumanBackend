package com.VumanBackend.Supplier;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.SupplierDao;
import com.DaoImpl.SupplierDaoImpl;
import com.config.HibernateConfig;
import com.model.Supplier;

public class TestGetSupplierById {
	private static SupplierDao supplierDao;
	private static HibernateConfig config;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		supplierDao = new SupplierDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}

	@Test
	public void testGetSupplierById() {
		Supplier expectedSupp = new Supplier();
		expectedSupp.setSid("1");
		expectedSupp.setSupplierName("Updated Supp");

		Supplier supplier = supplierDao.getSupplier("1");
		assertEquals(expectedSupp.getSid(), supplier.getSid());

		// System.out.println(supplier.getSid()+ " "+ supplier.getSupplierName());
	}
}
