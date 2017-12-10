package com.sa45.team3.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45.team3.model.Product;
import com.sa45.team3.model.Reorder;

public interface ReorderRepository extends JpaRepository<Reorder, Integer>{
	
	@Query("SELECT r FROM reorderdetails r WHERE r.partNumber=:searchNumber")
	ArrayList<Reorder> findReoderDetails(@Param("searchNumber") int searchNumber);
	
	@Query("SELECT r FROM reorderdetails r WHERE p.reorderID=:searchReorderID")
	ArrayList<Reorder> findReoderID(@Param("searchReoderID") int searchReoderID);
	
	
}
