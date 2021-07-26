//Author: Justin Wallace
//Date: 7/24/2021

package com.revature.models.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//database model for the user roles
@Entity
@Table(name = "user_roles")
public class UserRoles {
	
	//primary SERIAL key column
	//column referenced by role_id in users table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int role_id;
	
	//column for each role
	@Column(name = "role", nullable = false)
	private String role;

	
	
	//boiler plate
	public UserRoles() {
		super();
	}

	public UserRoles(String role) {
		super();
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoles [role_id=" + role_id + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + role_id;
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
		UserRoles other = (UserRoles) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (role_id != other.role_id)
			return false;
		return true;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getRole_id() {
		return role_id;
	}
	
}
