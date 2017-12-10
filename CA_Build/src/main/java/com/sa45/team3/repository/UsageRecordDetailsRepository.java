package com.sa45.team3.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.sa45.team3.model.UsageRecordDetails;

public interface UsageRecordDetailsRepository extends JpaRepository<UsageRecordDetails, Integer> {


	@Query("SELECT d from UsageRecordDetails d WHERE d.recordId = :rid")
	ArrayList<UsageRecordDetails> findUsageDetailsByrID(@Param("rid") int rid);

}
