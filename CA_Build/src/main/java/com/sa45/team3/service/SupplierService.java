package com.sa45.team3.service;

import java.util.ArrayList;


import com.sa45.team3.model.Supplier;

public interface SupplierService {

	ArrayList<Supplier> findAllSuppliers();

	ArrayList<String> findAllSupplierIDs();
	
	Supplier createSupplier(Supplier sup);
}