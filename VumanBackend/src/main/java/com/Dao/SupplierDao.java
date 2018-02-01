package com.Dao;

import java.util.List;

import com.model.Supplier;

public interface SupplierDao {
	public void insertSupplier(Supplier supplier);
	
	void updateSupplier(Supplier supplier);

	void deleteSupplier(Supplier supplier);
	
	List<Supplier> getAllSuppliers();
	
	Supplier getSupplier(String id);
}
