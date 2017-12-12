package com.sa45.team3.service;

import java.util.ArrayList;

import com.sa45.team3.model.Product;

public interface ProductService {

	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findAll()
	 */
	ArrayList<Product> findAll();

	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByID(int)
	 */
	Product findProductByID(int id);

	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByColor(java.lang.String)
	 */
	ArrayList<Product> findProductByColor(String color);

	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByName(java.lang.String)
	 */
	ArrayList<Product> findProductByName(String searchName);

	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByDescrp(java.lang.String)
	 */
	ArrayList<Product> findProductByDescrp(String searchDescrp);

	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByDimension(java.lang.String)
	 */
	ArrayList<Product> findProductByDimension(String searchDim);

	Product createProduct(Product product);

	Product editProduct(Product product);
	
	Product findProductByPartnumber(int id);

	void deleteProduct(Product p);

}