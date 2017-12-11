package com.sa45.team3.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "[usage details]")

public class UsageRecordDetails {

	
	public UsageRecordDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EmbeddedId
	private UsageDetailsPrimaryKey primarykey;

	private Integer usedQuantity;

	public UsageDetailsPrimaryKey getPrimarykey() {
		return primarykey;
	}

	public void setPrimarykey(UsageDetailsPrimaryKey primary) {
		this.primarykey = primary;
	}

	public Integer getUsedQuantity() {
		return usedQuantity;
	}

	public void setUsedQuantity(Integer usedQuantity) {
		this.usedQuantity = usedQuantity;
	}

	
	
}
