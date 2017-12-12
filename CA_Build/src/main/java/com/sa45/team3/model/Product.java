package com.sa45.team3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	private Integer partNumber;
	private String productName;
	private float unitPrice;
	private Integer quantity;
	private String description;
	private String color;
	private String dimension;
	private Integer reorderPoint;
	private Integer minOrder;
	private Integer supplierID;
	private String shelfLocation;
	
	
	public Integer getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(Integer partNumber) {
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
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
	public Integer getReorderPoint() {
		return reorderPoint;
	}
	public void setReorderPoint(Integer reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	public Integer getMinOrder() {
		return minOrder;
	}
	public void setMinOrder(Integer minOrder) {
		this.minOrder = minOrder;
	}
	public Integer getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(Integer supplierID) {
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
	public Product(Integer partNumber, String productName, float unitPrice, Integer quantity, String description, String color,
			String dimension, Integer reorderPoint, Integer minOrder, Integer supplierID, String shelfLocation) {
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
