package com.sa45.team3.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sa45.team3.model.Staff;






public interface StaffRepository extends JpaRepository<Staff,Integer>{
	@Query("SELECT u FROM staff u WHERE u.id=:un AND u.password=:pwd")
	Staff findUserByNamePwd(@Param("un") Integer uid, @Param("pwd") String pwd);

}

