package com.sa45.team3.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sa45.team3.model.Product;
import com.sa45.team3.repository.ProductRepository;

@Service
public class CatalogService {
	
	@Resource
	ProductRepository prepo;
	
	public ArrayList<Product>findAllProducts(){
		
		return (ArrayList<Product>) prepo.findAll();
	}
	
	
	public Product findProductByID(int id){
		
		return prepo.findOne(id);
	}
	
	
	
	
	
	
//	public static void main(String[]args) {
//		
//		
//		CatalogService cs = new CatalogService();
//		ArrayList<Product> APP = cs.findAllProducts();
//		System.out.println(APP);
//		
//		
//		
//	}
	
	
}
	






