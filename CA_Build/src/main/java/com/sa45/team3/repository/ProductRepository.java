package com.sa45.team3.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45.team3.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	//id
	
	@Query("SELECT p FROM Product p WHERE p.partNumber=:searchNumber")
	ArrayList<Product> findProductByID(@Param("searchNumber") int searchNumber);
	
	//name
	//add wildcards and LIKE 
	
	@Query("SELECT p FROM Product p WHERE p.productName=:searchName")
	ArrayList<Product> findProductByName(@Param("searchName") String searchName);
	
	//description
	
	@Query("SELECT p FROM Product p WHERE p.description=:searchDescrp")
	ArrayList<Product> findProductByDescrp(@Param("searchDescrp") String searchDescrp);
	
	
	//colour
	@Query("SELECT p FROM Product p WHERE p.color=:searchColor")
	ArrayList<Product> findProductByColor(@Param("searchColor") String searchColor);
	
	//dimension
	@Query("SELECT p FROM Product p WHERE p.dimension=:searchDim")
	ArrayList<Product> findProductByDimension(@Param("searchDim") String searchDim);
	//
	@Query("SELECT p FROM Product p WHERE p.partNumber=:searchNumber")
	Product findProductByPartnumber(@Param("searchNumber") int searchNumber);


}
