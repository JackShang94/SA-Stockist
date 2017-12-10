package com.sa45.team3.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sa45.team3.model.Staff;
import com.sa45.team3.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {

	@Resource
	private StaffRepository staffRepository;
	
	
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.StaffService#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public Staff authenticate(String uname, String pwd) {
		Staff u = staffRepository.findUserByNamePwd(uname, pwd);
		return u;
	}
	
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.StaffService#findStaffById(java.lang.String)
	 */
	@Override
	@Transactional
	public Staff findStaffById(int sid) {
		return staffRepository.findStaffById(sid);
	}
	
	/* (non-Javadoc)
	 * @see com.sa45.team3.service.StaffService#findSubordinates(java.lang.String)
	 */
	@Override
	public ArrayList<Staff> findSubordinates(int staffId) {
		return staffRepository.findSubordinates(staffId);
	}
	
	
}
