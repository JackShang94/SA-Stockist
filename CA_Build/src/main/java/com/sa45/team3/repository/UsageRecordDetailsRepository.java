package com.sa45.team3.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sa45.team3.model.UsageDetailsPrimaryKey;
import com.sa45.team3.model.UsageRecordDetails;

public interface UsageRecordDetailsRepository extends JpaRepository<UsageRecordDetails, UsageDetailsPrimaryKey> {



	@Query("SELECT d from UsageRecordDetails d WHERE d.primarykey.recordID =:rid")
	ArrayList<UsageRecordDetails> findUsageDetailsByrID(@Param("rid") Integer rid);
	
	@Query("SELECT d from UsageRecordDetails d WHERE d.primarykey.recordID =:rid AND d.primarykey.partNumber=:rid2")
	UsageRecordDetails findUsageDetailsByCompositeID(@Param("rid") Integer rid, @Param("rid2") Integer rid2);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO `ims-sa45team3`.`usage details` (`recordID`, `partNumber`, `usedQuantity`) VALUES (:recordid, :partnumber, :usedquantity)", nativeQuery = true)
	void addNewDetail(@Param("recordid") int recordid, @Param("partnumber") int partnumber, @Param("usedquantity") int usedquantity);
	
}
