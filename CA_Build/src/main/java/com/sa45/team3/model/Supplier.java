package com.sa45.team3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="suppliers")
public class Supplier {
	
	@Id
	private int supplierID;
	private String supplierName;
	private int contactNumber;
	private String address;
	private String contactPerson;
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#getSupplierID()
	 */

	public int getSupplierID() {
		return supplierID;
	}
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#setSupplierID(int)
	 */

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#getSupplierName()
	 */

	public String getSupplierName() {
		return supplierName;
	}
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#setSupplierName(java.lang.String)
	 */

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#getContactNumber()
	 */

	public int getContactNumber() {
		return contactNumber;
	}
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#setContactNumber(int)
	 */

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#getAddress()
	 */

	public String getAddress() {
		return address;
	}
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#setAddress(java.lang.String)
	 */

	public void setAddress(String address) {
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#getContactPerson()
	 */

	public String getContactPerson() {
		return contactPerson;
	}
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#setContactPerson(java.lang.String)
	 */

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public Supplier(int supplierID, String supplierName, int contactNumber, String address, String contactPerson) {
		super();
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.contactPerson = contactPerson;
	}
	public Supplier() {
		super();
	}
	/* (non-Javadoc)
	 * @see sg.edu.alex.learning.model.SupplierRepository#toString()
	 */

	public String toString() {
		return "Supplier [supplierID=" + supplierID + ", supplierName=" + supplierName + ", contactNumber="
				+ contactNumber + ", address=" + address + ", contactPerson=" + contactPerson + "]";
	}
	
	
	
	

}
