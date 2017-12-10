package com.sa45.team3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name="reorder")

public class Reorder {
	
	@Id
	private int partNumber;
	private int reorderID;
	private int orderQuantity;
	private float unitPrice;
	Date dateOrdered;
	
	public Reorder(int partNumber, int reorderID, int orderQuantity, float unitPrice, Date dateOrdered) {
		super();
		this.partNumber = partNumber;
		this.reorderID = reorderID;
		this.orderQuantity = orderQuantity;
		this.unitPrice = unitPrice;
		this.dateOrdered = dateOrdered;
	}

	public Reorder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public int getReorderID() {
		return reorderID;
	}

	public void setReorderID(int reorderID) {
		this.reorderID = reorderID;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	@Override
	public String toString() {
		return "Reorder [Item Number=" + partNumber + ", Reorder ID=" + reorderID + ", Order Quantity="
				+ orderQuantity + ", Unit Price=" + unitPrice + ", Date Ordered=" + dateOrdered + "]";
	}

}
