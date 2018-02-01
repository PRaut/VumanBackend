package com.VumanBackend.Supplier;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.Dao.SupplierDao;
import com.DaoImpl.SupplierDaoImpl;
import com.config.HibernateConfig;
import com.model.Supplier;

public class TestGetAllSuppliers {
	private static SupplierDao supplierDao;
	private static HibernateConfig config;

	@BeforeClass
	public static void setUp() {
		config = new HibernateConfig();
		supplierDao = new SupplierDaoImpl(config.getSessionFactory(config.getH2DataSource()));
	}
	
	@Test
	public void testGetAllSuppliers(){
		List<Supplier> suppliersList = new ArrayList();
		suppliersList = supplierDao.getAllSuppliers();
		for(Supplier supp: suppliersList)
			System.out.println(supp.getSid() +" "+ supp.getSupplierName());
		
	}
}
