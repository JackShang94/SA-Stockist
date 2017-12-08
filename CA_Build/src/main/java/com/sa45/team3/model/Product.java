package com.sa45.team3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	private int partNumber;
	private String productName;
	private float unitPrice;
	private int quantity;
	private String description;
	private String color;
	private String dimension;
	private int reorderPoint;
	private int minOrder;
	private int supplierID;
	private String shelfLocation;
	
	
	public int getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public int getReorderPoint() {
		return reorderPoint;
	}
	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	public int getMinOrder() {
		return minOrder;
	}
	public void setMinOrder(int minOrder) {
		this.minOrder = minOrder;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public String getShelfLocation() {
		return shelfLocation;
	}
	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}
	public Product() {
		super();
	}
	public Product(int partNumber, String productName, float unitPrice, int quantity, String description, String color,
			String dimension, int reorderPoint, int minOrder, int supplierID, String shelfLocation) {
		super();
		this.partNumber = partNumber;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.description = description;
		this.color = color;
		this.dimension = dimension;
		this.reorderPoint = reorderPoint;
		this.minOrder = minOrder;
		this.supplierID = supplierID;
		this.shelfLocation = shelfLocation;
	}
	@Override
	public String toString() {
		return "Product [partNumber=" + partNumber + ", productName=" + productName + ", unitPrice=" + unitPrice
				+ ", Quantity=" + quantity + ", description=" + description + ", color=" + color + ", dimension="
				+ dimension + ", reorderPoint=" + reorderPoint + ", minOrder=" + minOrder + ", supplierID=" + supplierID
				+ ", shelfLocation=" + shelfLocation + "]";
	}
	
	
	

}
