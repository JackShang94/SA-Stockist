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
		private StaffRepository staffRepository;
		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#findAllUsers()
		 */
		
		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#findAllUsers()
		 */
		@Override
		@Transactional
		public ArrayList<Staff> findAllUsers() {
			ArrayList<Staff> a=(ArrayList<Staff>)staffRepository.findAll();
			return a;
		}

		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#findUser(java.lang.Integer)
		 */
		
		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#findUser(java.lang.Integer)
		 */
		@Override
		@Transactional
		public Staff findUser(Integer userId) {
			
			return staffRepository.findOne(userId);
		}

		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#createUser(com.sa45.team3.model.Staff)
		 */
		
		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#createUser(com.sa45.team3.model.Staff)
		 */
		@Override
		@Transactional
		public Staff createUser(Staff user) {
			
			return staffRepository.saveAndFlush(user);
		}

		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#changeUser(com.sa45.team3.model.Staff)
		 */
		
		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#changeUser(com.sa45.team3.model.Staff)
		 */
		@Override
		@Transactional
		public Staff changeUser(Staff user) {
			return staffRepository.saveAndFlush(user);
			
		}

		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#removeUser(com.sa45.team3.model.Staff)
		 */
		
		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#removeUser(com.sa45.team3.model.Staff)
		 */
		@Override
		@Transactional
		public void removeUser(Staff user) {
			 staffRepository.delete(user);
			
			
		}

		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#authenticate(java.lang.String, java.lang.String)
		 */
		
		/* (non-Javadoc)
		 * @see com.sa45.team3.service.StaffService#authenticate(java.lang.String, java.lang.String)
		 */
		@Override
		@Transactional
		public Staff authenticate(String uname, String pwd) {
			Staff u = staffRepository.findUserByNamePwd(uname, pwd);
			return u;
		}
		
		

	}



