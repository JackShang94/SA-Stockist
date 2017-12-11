package com.sa45.team3.service;


	import java.util.ArrayList;

	import javax.annotation.Resource;


	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;
	import com.sa45.team3.repository.StaffRepository;

import com.sa45.team3.model.Staff;

	
	@Service

	public class StaffServiceImpl implements StaffService{

		@Resource
		private StaffRepository UserRepository;
		@Override
		@Transactional
		public ArrayList<Staff> findAllUsers() {
			ArrayList<Staff> a=(ArrayList<Staff>)UserRepository.findAll();
			return a;
		}

		@Override
		@Transactional
		public Staff findUser(Integer userId) {
			
			return UserRepository.findOne(userId);
		}

		@Override
		@Transactional
		public Staff createUser(Staff user) {
			
			return UserRepository.saveAndFlush(user);
		}

		@Override
		@Transactional
		public Staff changeUser(Staff user) {
			return UserRepository.saveAndFlush(user);
			
		}

		@Override
		@Transactional
		public void removeUser(Staff user) {
			 UserRepository.delete(user);
			
			
		}

		@Transactional
		public Staff authenticate(Integer uid, String pwd) {
			Staff s=UserRepository.findUserByNamePwd(uid, pwd);
			return s;
		}
		

	}



