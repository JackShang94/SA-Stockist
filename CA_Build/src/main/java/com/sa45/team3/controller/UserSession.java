package com.sa45.team3.controller;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.sa45.team3.model.Staff;


@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	
	private String sessionId = null;
	private Staff staff = null;
	private ArrayList<Staff> subordinates = null;
	public UserSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSession(String sessionId, Staff staff, ArrayList<Staff> subordinates) {
		super();
		this.sessionId = sessionId;
		this.staff = staff;
		this.subordinates = subordinates;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public ArrayList<Staff> getSubordinates() {
		return subordinates;
	}
	public void setSubordinates(ArrayList<Staff> subordinates) {
		this.subordinates = subordinates;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
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
		UserSession other = (UserSession) obj;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		return true;
	}
	
	

}
