package com.sa45.team3.service;

import java.util.ArrayList;

import com.sa45.team3.model.Product;

public interface ProductCatalogService {

	ArrayList<Product> findAll();

	Product findProductByID(int id);

	ArrayList<Product> findProductByColor(String color);

	ArrayList<Product> findProductByName(String searchName);

	ArrayList<Product> findProductByDescrp(String searchDescrp);

	ArrayList<Product> findProductByDimension(String searchDim);

	void updateQuantity(int quantity, int partNumber);

}