package com.sa45.team3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="suppliers")
public class Supplier {
	
	@Id
	private Integer supplierID;
	private String supplierName;
	private Integer contactNumber;
	private String address;
	private String contactPerson;
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(Integer supplierID, String supplierName, Integer contactNumber, String address,
			String contactPerson) {
		super();
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.contactPerson = contactPerson;
	}

	public Integer getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supplierID == null) ? 0 : supplierID.hashCode());
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
		Supplier other = (Supplier) obj;
		if (supplierID == null) {
			if (other.supplierID != null)
				return false;
		} else if (!supplierID.equals(other.supplierID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Supplier [supplierID=" + supplierID + ", supplierName=" + supplierName + ", contactNumber="
				+ contactNumber + ", address=" + address + ", contactPerson=" + contactPerson + "]";
	}
	
	
	

}
