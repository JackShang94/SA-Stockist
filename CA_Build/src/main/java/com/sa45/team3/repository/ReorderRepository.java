package com.sa45.team3.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45.team3.model.Product;
import com.sa45.team3.model.Reorder;

public interface ReorderRepository extends JpaRepository<Reorder, Integer>{
	
	@Query("SELECT r FROM reorderdetails r WHERE r.partNumber=:searchNumber")
	ArrayList<Reorder> findReorderDetails(@Param("searchNumber") int searchNumber);
	
	@Query("SELECT r FROM reorderdetails r WHERE r.reorderID=:searchReorderID")
	ArrayList<Reorder> findReorderID(@Param("searchReoderID") int searchReoderID);
	
	@Query("SELECT r FROM reorderdetails r WHERE r.reorderQuantity=:searchQuantity")
	ArrayList<Reorder> findReorderQuant(@Param("searchQuantity") int searchQuantity);
	
	@Query("SELECT p FROM product p WHERE p.unitPrice=:searchPrice")
	ArrayList<Reorder> findUnitPrice(@Param("searchPrice") int searchPrice);
	
	@Query("SELECT q FROM reorders q WHERE q.dateOrdered=:searchDate")
	ArrayList<Reorder> findDateOrdered(@Param("searchDate") int searchDate);
}
