package com.sa45.team3.model;

public class ReorderReport {
	private int partNumber;
	private float unitPrice;
	private int quantity;
	private int reorderquantity;
	private int minorderQty;
	private int orderQty;
	public int getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
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
	public int getReorderquantity() {
		return reorderquantity;
	}
	public void setReorderquantity(int reorderquantity) {
		this.reorderquantity = reorderquantity;
	}
	public int getMinorderQty() {
		return minorderQty;
	}
	public void setMinorderQty(int minorderQty) {
		this.minorderQty = minorderQty;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	private float price;
	
}
