package com.sa45.team3.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.sa45.team3.model.UsageRecordDetails;

public interface UsageRecordDetailsRepository extends JpaRepository<UsageRecordDetails, Integer> {


	@Query("SELECT d from UsageRecordDetails d WHERE d.recordID = :rid")
	ArrayList<UsageRecordDetails> findUsageDetailsByrID(@Param("rid") int rid);
	
	@Query("INSERT INTO [usage details] (recordID, partNumber, usedQuantity) VALUES (:recordid, :partnumber, :usedquantity) ")
	void addNewDetail(@Param("recordid") int recordid, @Param("partnumber") int partnumber, @Param("usedquantity") int usedquantity);

}
