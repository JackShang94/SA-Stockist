package com.sa45.team3.model;

import com.sa45.team3.model.*;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReorderPrimaryKey implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name="reorderID")
	private int reorderID;
	@Column(name="partNumber")
	private int partNumber;
	public int getReorderID() {
		return reorderID;
	}
	public void setReorderID(int reorderID) {
		this.reorderID = reorderID;
	}
	public int getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partNumber;
		result = prime * result + reorderID;
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
		ReorderPrimaryKey other = (ReorderPrimaryKey) obj;
		if (partNumber != other.partNumber)
			return false;
		if (reorderID != other.reorderID)
			return false;
		return true;
	}
	
	
}
