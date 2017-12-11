package com.sa45.team3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "[usage details]")

public class UsageRecordDetails {

	public UsageRecordDetails(int recordID, int partNumber, int usedQuantity) {
		super();
		this.recordID = recordID;
		this.partNumber = partNumber;
		this.usedQuantity = usedQuantity;
	}

	public UsageRecordDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	private int recordID;

	private int partNumber;

	private int usedQuantity;

	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public int getUsedQuantity() {
		return usedQuantity;
	}

	public void setUsedQuantity(int usedQuantity) {
		this.usedQuantity = usedQuantity;
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
		UsageRecordDetails other = (UsageRecordDetails) obj;
		if (recordID != other.recordID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsageRecordDetails [recordID=" + recordID + ", partNumber=" + partNumber + ", usedQuantity="
				+ usedQuantity + "]";
	}

}
