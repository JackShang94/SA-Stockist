package com.sa45.team3.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sa45.team3.model.Product;
import com.sa45.team3.repository.ProductRepository;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

	@Resource
	ProductRepository prepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sa45.team3.service.ProductCatalogService#findAll()
	 */
	@Override
	public ArrayList<Product> findAll() {

		return (ArrayList<Product>) prepo.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByID(int)
	 */
	@Override
	public Product findProductByID(int id) {

		return prepo.findProductByID(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sa45.team3.service.ProductCatalogService#findProductByColor(java.lang.
	 * String)
	 */
	@Override
	public ArrayList<Product> findProductByColor(String color) {

		return prepo.findProductByColor(color);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sa45.team3.service.ProductCatalogService#findProductByName(java.lang.
	 * String)
	 */
	@Override
	public ArrayList<Product> findProductByName(String searchName) {

		return prepo.findProductByName(searchName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sa45.team3.service.ProductCatalogService#findProductByDescrp(java.lang.
	 * String)
	 */
	@Override
	public ArrayList<Product> findProductByDescrp(String searchDescrp) {

		return prepo.findProductByDescrp(searchDescrp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sa45.team3.service.ProductCatalogService#findProductByDimension(java.lang
	 * .String)
	 */
	@Override
	public ArrayList<Product> findProductByDimension(String searchDim) {

		return prepo.findProductByDimension(searchDim);
	}

	@Override
	public void updateQuantity(int quantity, int partNumber) {
		
		 prepo.updateQuantity(quantity, partNumber);
	}

	// public static void main(String[]args) {
	//
	//
	// CatalogService cs = new CatalogService();
	// ArrayList<Product> APP = cs.findAllProducts();
	// System.out.println(APP);
	//
	//
	//
	// }

}
