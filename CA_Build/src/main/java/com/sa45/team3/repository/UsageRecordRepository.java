package com.sa45.team3.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45.team3.model.UsageRecord;

public interface UsageRecordRepository extends JpaRepository<UsageRecord, Integer> {
	
@Query("SELECT ur FROM UsageRecord ur WHERE ur.recordID =:id")	
ArrayList<UsageRecord> findRecordById(@Param("id") Integer id);

@Query("SELECT DISTINCT ur.recordID FROM UsageRecord ur")
ArrayList<String> findAllrecordIDs();

}
