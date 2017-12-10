package com.sa45.team3.service;

import java.util.ArrayList;

import com.sa45.team3.model.Staff;

public interface StaffService {

	Staff authenticate(String uname, String pwd);

	Staff findStaffById(int sid);

	ArrayList<Staff> findSubordinates(int staffId);

}