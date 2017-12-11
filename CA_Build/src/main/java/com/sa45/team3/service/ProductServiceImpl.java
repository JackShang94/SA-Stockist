package com.sa45.team3.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.sa45.team3.model.Product;
import com.sa45.team3.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService  {
	@Resource
	ProductRepository prepo;
	
	

	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductService#findAll()
	 */
	@Override
	public ArrayList<Product>findAll(){
		
		return (ArrayList<Product>) prepo.findAll();
	}
	
	
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByID(int)
	 */
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductService#findProductByID(int)
	 */
	@Override
	public ArrayList<Product> findProductByID(int id){
		
		return prepo.findProductByID(id);
	}
	
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByColor(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductService#findProductByColor(java.lang.String)
	 */
	@Override
	public ArrayList<Product>findProductByColor(String color){
		
		return prepo.findProductByColor(color);
	}
	
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByName(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductService#findProductByName(java.lang.String)
	 */
	@Override
	public ArrayList<Product>findProductByName(String searchName){
		
		return prepo.findProductByName(searchName);
	}
	
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByDescrp(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductService#findProductByDescrp(java.lang.String)
	 */
	@Override
	public ArrayList<Product>findProductByDescrp(String searchDescrp){
		
		return prepo.findProductByDescrp(searchDescrp);
	}
	
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductCatalogService#findProductByDimension(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.ProductService#findProductByDimension(java.lang.String)
	 */
	@Override
	public ArrayList<Product>findProductByDimension(String searchDim){
		
		return prepo.findProductByDimension(searchDim);
	}


	@Override
	public Product createProduct(Product product) {
		
		return  prepo.saveAndFlush(product);
	}


	@Override
	public Product editProduct(Product product) {
		return  prepo.saveAndFlush(product);
	}


	@Override
	public Product findProductByPartnumber(int id) {
		return prepo.findProductByPartnumber(id);
	}


	@Override
	public void deleteProduct(Product p) {
		prepo.delete(p);
	}
	
}
