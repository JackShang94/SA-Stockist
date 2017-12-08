package com.sa45.team3.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usage records")

public class UsageRecord {
	
	@Id
	private int recordID;
	@Basic
	private String customerName;
	@Basic
	private int staffID;
	@Basic
	private Date usageDate;
	@Basic
	private int contactNumber;
	
	
	
	

}
