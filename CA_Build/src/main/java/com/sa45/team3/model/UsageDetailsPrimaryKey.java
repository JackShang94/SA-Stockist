package com.sa45.team3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsageDetailsPrimaryKey implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="recordID")
	private Integer recordID;
	@Column(name="partNumber")
	private Integer partNumber;
	public Integer getRecordID() {
		return recordID;
	}
	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}
	public Integer getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(Integer partNumber) {
		this.partNumber = partNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partNumber;
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
		UsageDetailsPrimaryKey other = (UsageDetailsPrimaryKey) obj;
		if (partNumber != other.partNumber)
			return false;
		if (recordID != other.recordID)
			return false;
		return true;
	}
	
	
}
