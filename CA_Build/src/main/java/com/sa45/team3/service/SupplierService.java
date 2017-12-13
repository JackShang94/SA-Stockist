package com.sa45.team3.service;

import java.util.ArrayList;

import com.sa45.team3.model.Supplier;


public interface SupplierService {

	ArrayList<Supplier> findAllSuppliers();

	ArrayList<Integer> findAllSupplierIDs();
	
	Supplier createSupplier(Supplier sup);

	Supplier findSupplierById(Integer s);

	Supplier editSupplier(Supplier sup);

	void deleteSupplier(Supplier sup);
	
	Supplier findSupplier(Integer supid);
	
	ArrayList<Supplier> searchSupplierByContactNumber(Integer num);
	
	ArrayList<Supplier>searchSupplierByName(String name);
	
	Supplier checkSupplier(String sname, Integer cNumber);
	
}