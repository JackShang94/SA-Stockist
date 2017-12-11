package com.sa45.team3.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45.team3.model.Product;
import com.sa45.team3.model.Reorders;

public interface ReorderRepository extends JpaRepository<Reorders, Integer>{
	
	@Query("SELECT r FROM ReorderDetails r WHERE r.primary.partNumber=:searchNumber")
	ArrayList<Reorders> findReorderDetails(@Param("searchNumber") int searchNumber);
	
	@Query("SELECT r FROM Reorders r WHERE r.reorderID=:searchReorderID")
	ArrayList<Reorders> findReorderID(@Param("searchReorderID") int searchReorderID);
	
	@Query("SELECT r FROM ReorderDetails r WHERE r.orderQuantity=:searchQuantity")
	ArrayList<Reorders> findReorderQuant(@Param("searchQuantity") int searchQuantity);
	
	@Query("SELECT r FROM Reorders r WHERE r.dateOrdered=:searchDate")
	ArrayList<Reorders> findDateOrdered(@Param("searchDate") int searchDate);
}
