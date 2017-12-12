package com.sa45.team3.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.sa45.team3.model.UsageDetailsPrimaryKey;
import com.sa45.team3.model.UsageRecord;
import com.sa45.team3.model.UsageRecordDetails;

public interface UsageRecordService {

	ArrayList<UsageRecord> findAllrecordIDs();

	UsageRecord createUsageRecord(UsageRecord uR);
	
	ArrayList<UsageRecordDetails> findAllRecordDetails(Integer id);
	
	UsageRecord findUsageRecordbyID(Integer id);

	ArrayList<UsageRecordDetails> findAllRecordDetailsByID(Integer id);

	UsageRecordDetails findRecordDetails(UsageDetailsPrimaryKey did);

	UsageRecord editUsageRecord(UsageRecord uR);
	
}