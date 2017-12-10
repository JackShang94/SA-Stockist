package com.sa45.team3.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.sa45.team3.model.Supplier;

public interface SupplierService {

	ArrayList<Supplier> findAllSuppliers();

	
}