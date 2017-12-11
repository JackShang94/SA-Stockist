package com.sa45.team3.model;


	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="staff")

	public class Staff {
		@Id
		private int staffID;
		private String password;
		private String name;
		private String role;
		private int contactNumber;
		private int active;
		public int getStaffID() {
			return staffID;
		}
		public void setStaffID(int staffID) {
			this.staffID = staffID;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public int getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(int contactNumber) {
			this.contactNumber = contactNumber;
		}
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}
		public Staff(int staffID, String password, String name, String role, int contactNumber, int active) {
			super();
			this.staffID = staffID;
			this.password = password;
			this.name = name;
			this.role = role;
			this.contactNumber = contactNumber;
			this.active = active;
		}
		public Staff() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + active;
			result = prime * result + contactNumber;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((role == null) ? 0 : role.hashCode());
			result = prime * result + staffID;
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
			Staff other = (Staff) obj;
			if (active != other.active)
				return false;
			if (contactNumber != other.contactNumber)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (role == null) {
				if (other.role != null)
					return false;
			} else if (!role.equals(other.role))
				return false;
			if (staffID != other.staffID)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "staff [staffID=" + staffID + ", password=" + password + ", name=" + name + ", role=" + role
					+ ", contactNumber=" + contactNumber + ", active=" + active + "]";
		}
		
		
	}


