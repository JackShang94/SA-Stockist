package com.sa45.team3.service;

import java.util.ArrayList;

import com.sa45.team3.model.Staff;



public interface StaffService {
	ArrayList<Staff> findAllUsers();

	Staff findUser(Integer userId);

Staff createUser(Staff user);

	Staff changeUser(Staff user);

	void removeUser(Staff user);
	Staff authenticate(String uname, String pwd);

	ArrayList<Integer> findAllStaffIDs();

	

}
