package com.sa45.team3.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sa45.team3.model.Product;
import com.sa45.team3.model.UsageDetailsPrimaryKey;
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
	

	@Override
	@Transactional
	public ArrayList<UsageRecord> findAllrecordIDs() {
		ArrayList<UsageRecord> l = (ArrayList<UsageRecord>) usageRecordRepository.findAll();
		return l;
	}
	
	
	@Override
	@Transactional
	public UsageRecord findUsageRecordbyID(Integer id) {
		return usageRecordRepository.findOne(id);
	}

	@Override
	@Transactional
	public UsageRecord createUsageRecord(UsageRecord uR) {
		return usageRecordRepository.saveAndFlush(uR);
	}
	
	@Override
	@Transactional
	public UsageRecord editUsageRecord(UsageRecord uR) {
		return  usageRecordRepository.saveAndFlush(uR);
	}
	
	@Override
	@Transactional
	public UsageRecordDetails findRecordDetails(UsageDetailsPrimaryKey did) {
		return usageRecordDetailsRepository.findOne(did);

	}
	
	
	@Override
	@Transactional
	public ArrayList<UsageRecordDetails> findAllRecordDetailsByID(Integer id){
		return usageRecordDetailsRepository.findUsageDetailsByrID(id);
	}


	@Override
	public ArrayList<UsageRecordDetails> findAllRecordDetails(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
