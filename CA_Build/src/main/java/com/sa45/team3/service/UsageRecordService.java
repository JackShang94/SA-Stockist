package com.sa45.team3.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.sa45.team3.model.UsageRecord;
import com.sa45.team3.model.UsageRecordDetails;

public interface UsageRecordService {

	ArrayList<UsageRecord> findAllrecordIDs();

	UsageRecord findUsageRecordbyID(int id);

	UsageRecord createUsageRecord(UsageRecord uR);

	UsageRecordDetails findRecordDetails(int did);
	
}