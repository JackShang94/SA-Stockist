package com.sa45.team3.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45.team3.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

	@Query("SELECT s FROM Staff s WHERE s.name=:un AND s.password=:pwd")
	Staff findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);
	
	@Query("SELECT s FROM Staff s where s.id = :id")
	Staff findStaffById(@Param("id") int id);
	
	@Query("SELECT DISTINCT s2 FROM Staff s1, Staff s2 WHERE s1.id = s2.id AND s1.id = :sid")
	ArrayList<Staff> findSubordinates(@Param("sid") int sid);
}
