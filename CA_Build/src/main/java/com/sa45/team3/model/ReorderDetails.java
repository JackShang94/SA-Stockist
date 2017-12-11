package com.sa45.team3.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;


@Entity
@Table(name = "reorder details")
public class ReorderDetails {
	@EmbeddedId
	private ReorderPrimaryKey primary;
	
	private int orderQuantity;
	
	private String description;

	public ReorderPrimaryKey getPrimary() {
		return primary;
	}

	public void setPrimary(ReorderPrimaryKey primary) {
		this.primary = primary;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
