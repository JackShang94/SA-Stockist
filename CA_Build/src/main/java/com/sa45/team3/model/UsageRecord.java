package com.sa45.team3.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[usage records]")

public class UsageRecord {
	
	public UsageRecord(int recordID, String customerName, int staffID, Date usageDate, int contactNumber) {
		super();
		this.recordID = recordID;
		this.customerName = customerName;
		this.staffID = staffID;
		this.usageDate = usageDate;
		this.contactNumber = contactNumber;
	}

	public UsageRecord(int recordID) {
		super();
		this.recordID = recordID;
	}

	public UsageRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private int recordID;
	
	private String customerName;

	private int staffID;
	
	private Date usageDate;

	private int contactNumber;

	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public Date getUsageDate() {
		return usageDate;
	}

	public void setUsageDate(Date usageDate) {
		this.usageDate = usageDate;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + recordID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsageRecord other = (UsageRecord) obj;
		if (recordID != other.recordID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsageRecord [recordID=" + recordID + ", staffID=" + staffID + ", usageDate=" + usageDate + "]";
	}
	
	
	
	

}
