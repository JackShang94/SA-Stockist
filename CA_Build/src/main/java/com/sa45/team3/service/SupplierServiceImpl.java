package com.sa45.team3.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa45.team3.exception.SupplierCantDelete;
import com.sa45.team3.model.Product;
import com.sa45.team3.model.Staff;
import com.sa45.team3.model.Supplier;
import com.sa45.team3.repository.ProductRepository;
import com.sa45.team3.repository.SupplierRepository;


@Service
public class SupplierServiceImpl implements SupplierService {

	@Resource
	SupplierRepository supRepository;
	@Resource
	ProductRepository proRepository;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sa45.team3.service.SupplierService#findAllSuppliers()
	 */
	@Override
	@Transactional
	public ArrayList<Supplier> findAllSuppliers() {
		ArrayList<Supplier> l = (ArrayList<Supplier>) supRepository.findAll();
		return l;
	}

	@Override
	@Transactional
	public ArrayList<Integer> findAllSupplierIDs() {
		return supRepository.findAllSupplierIDs();
	}

	
	@Override
	@Transactional
	public Supplier createSupplier(Supplier sup) {
		return supRepository.saveAndFlush(sup);
	}
	/*
	 * @Override
	 * 
	 * @Transactional public Supplier findSupplierID(String supid) { return
	 * supRepository.findOne(supid); }
	 */

	/*
	 * @Override
	 * 
	 * @Transactional public Supplier findSupplier(String supid) { return
	 * supRepository.findOne(supid); }
	 */

	@Override
	@Transactional
	public Supplier findSupplierById(Integer s) {
		return supRepository.findSupplierById(s);
	}

	
	@Override
	@Transactional
	public Supplier editSupplier(Supplier sup) {
		return supRepository.saveAndFlush(sup);
	}

	/*@Override
	@Transactional
	public void deleteSupplier(Supplier sup) throws SupplierCantDelete {
		if (!proRepository.checkSupplierID(sup.getSupplierID()).equals(sup)) {
			throw new SupplierCantDelete("xxxxxxx");
		}
	}*/
	
	@Override
	@Transactional
	public void deleteSupplier(Supplier sup) {
		supRepository.delete(sup);
	}
	
	@Override
	@Transactional
	public Supplier findSupplier(Integer supid) {
		return supRepository.findOne(supid);

	}
	
	@Override
	@Transactional
	public ArrayList<Supplier> searchSupplierByContactNumber(Integer num){		
		return supRepository.searchSupplierByContactNumber(num);
	}
	
	@Override
	@Transactional
	public ArrayList<Supplier>searchSupplierByName(String name){
		
		return supRepository.searchSupplierByName(name);
	}
	
	@Override
	@Transactional
	public Supplier checkSupplier(String sname, Integer cNumber) {
		Supplier s = supRepository.sNamecNumber(sname, cNumber);
		return s;
	}
}
