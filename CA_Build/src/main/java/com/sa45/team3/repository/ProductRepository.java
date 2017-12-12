package com.sa45.team3.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sa45.team3.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	//id
	
	@Query("SELECT p FROM Product p WHERE p.partNumber=:searchNumber")
	Product findProductByID(@Param("searchNumber") int searchNumber);
	
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
	
	@Modifying
	@Transactional
	@Query("UPDATE Product p SET p.quantity =(p.quantity - :quantity) WHERE p.partNumber=:partNumber")
	void updateQuantity(@Param("quantity") int quantity, @Param("partNumber") int partNumber);
	
	@Query("SELECT p FROM Product p WHERE p.quantity<= p.reorderPoint")
	ArrayList<Product> findProductsToReorder(); //get all products under minimum level
	
	@Query("SELECT p FROM Product p WHERE (p.quantity<= p.reorderPoint AND p.supplierID =:supplierID)")
	ArrayList<Product> findProductsToReorder(@Param("supplierID")Integer supplierID); //get products to reorder by supplier
	
    @Query("SELECT p.quantity-p.reorderPoint FROM Product p")
	ArrayList<Integer> findQty_ReorderQty();
    
    @Query("SELECT p.quantity-p.reorderPoint FROM Product p WHERE (p.supplierID =:supplierID)")
	ArrayList<Integer> findQty_ReorderQtyBysupplierID(@Param("supplierID") Integer supplierID);

    @Query("SELECT p FROM Product p WHERE (p.supplierID =:supplierID)")
	ArrayList<Product> findProductsBySupplier(@Param("supplierID") Integer supplierID);

}
