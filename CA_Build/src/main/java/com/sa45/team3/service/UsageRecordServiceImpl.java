package com.sa45.team3.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa45.team3.model.UsageRecord;
import com.sa45.team3.model.UsageRecordDetails;
import com.sa45.team3.repository.UsageRecordDetailsRepository;
import com.sa45.team3.repository.UsageRecordRepository;



@Service
public class UsageRecordServiceImpl implements UsageRecordService {

	@Resource
	private UsageRecordRepository usageRecordRepository;
	@Resource
	private UsageRecordDetailsRepository usageRecordDetailsRepository;
	

	/* (non-Javadoc)
	 * @see com.sa45.team3.service.UsageRecordService#findAllrecordIDs()
	 */
	@Override
	@Transactional
	public ArrayList<UsageRecord> findAllrecordIDs() {
		ArrayList<UsageRecord> l = (ArrayList<UsageRecord>) usageRecordRepository.findAll();
		return l;
	}

	
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.UsageRecordService#findUsageRecordbyID(int)
	 */
	@Override
	@Transactional
	public UsageRecord findUsageRecordbyID(int id) {
		return usageRecordRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.sa45.team3.service.UsageRecordService#createUsageRecord(com.sa45.team3.model.UsageRecord)
	 */
	@Override
	@Transactional
	public UsageRecord createUsageRecord(UsageRecord uR) {
		return usageRecordRepository.saveAndFlush(uR);
	}
	
	@Override
	@Transactional
	public UsageRecordDetails findRecordDetails(int did) {
		return usageRecordDetailsRepository.findOne(did);

	}
}
