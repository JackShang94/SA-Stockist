package com.sa45.team3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name="Reorders")

public class Reorders {
	
	@Id
	private int reorderID;
	private int staffID	;
	Date dateOrdered;
	

	public Reorders() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getReorderID() {
		return reorderID;
	}


	public void setReorderID(int reorderID) {
		this.reorderID = reorderID;
	}


	public int getStaffID() {
		return staffID;
	}


	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}


	public Date getDateOrdered() {
		return dateOrdered;
	}


	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}



}
