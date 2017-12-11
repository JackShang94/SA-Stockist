package com.sa45.team3.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="[usage records]")

public class UsageRecord {
	
	public UsageRecord(Integer recordID, String customerName, Integer staffID, Date usageDate, Integer contactNumber) {
		super();
		this.recordID = recordID;
		this.customerName = customerName;
		this.staffID = staffID;
		this.usageDate = usageDate;
		this.contactNumber = contactNumber;
	}

	public UsageRecord(Integer recordID) {
		super();
		this.recordID = recordID;
	}

	public UsageRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private Integer recordID;
	
	private String customerName;

	private Integer staffID;
	
	private Date usageDate;

	private Integer contactNumber;

	public Integer getRecordID() {
		return recordID;
	}

	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getStaffID() {
		return staffID;
	}

	public void setStaffID(Integer staffID) {
		this.staffID = staffID;
	}

	public Date getUsageDate() {
		return usageDate;
	}

	public void setUsageDate(Date usageDate) {
		this.usageDate = usageDate;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
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
