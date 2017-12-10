package com.sa45.team3.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {
	
	@Id
	private int staffID;
	private String password;
	private String name;

	private String role;
	private int contactNumber;
	private int active;
	

	
	public Staff(int staffID, String password, String name, String role, int contactNumber, int active) {
		super();
		this.staffID = staffID;
		this.password = password;
		this.name = name;
		this.role = role;
		this.contactNumber = contactNumber;
		this.active = active;
	}

	public Staff() {
		super();
	}
	
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	

}
