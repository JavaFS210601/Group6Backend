//Author: Justin Wallace
//Date: 7/24/2021
package com.revature.models.database;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//database model for users
@Entity
@Table(name = "users")
public class Users {
	
	//primary SERIAL key column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;
	
	//column for usernames
	@Column(name = "username", nullable = false)
	private String username;
	
	//column for passwords
	@Column(name = "password", nullable = false)
	private String password;
	
	//column for first names
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	//column for lastnames
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	//for key column referencing role_id in user_roles table
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = UserRoles.class)
	@JoinColumn(name = "role_id")
	private UserRoles role_id;
	
	//boilerplate
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String username, String password, String first_name, String last_name, UserRoles role_id) {
		super();
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.role_id = role_id;
	}
	
	

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", first_name="
				+ first_name + ", last_name=" + last_name + ", role_id=" + role_id + "]";
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(first_name, last_name, password, role_id, user_id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(first_name, other.first_name) && Objects.equals(last_name, other.last_name)
				&& Objects.equals(password, other.password) && Objects.equals(role_id, other.role_id)
				&& user_id == other.user_id && Objects.equals(username, other.username);
	}

	public int getUser_id() {
		return user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public UserRoles getRole_id() {
		return role_id;
	}

	public void setRole_id(UserRoles role_id) {
		this.role_id = role_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	
}
