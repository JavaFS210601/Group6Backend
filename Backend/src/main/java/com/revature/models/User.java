package com.revature.models;

import java.util.Objects;

public class User {

	private int user_id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private int role_id;
	private int recipe_id;

	
	
	//boilerplate code below--------------------------
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(int user_id, String username, String password, String firstname, String lastname, int role_id,
			int recipe_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role_id = role_id;
		this.recipe_id = recipe_id;
	}



	public User(String username, String password, String firstname, String lastname, int role_id, int recipe_id) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role_id = role_id;
		this.recipe_id = recipe_id;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
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



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public int getRole_id() {
		return role_id;
	}



	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}



	public int getRecipe_id() {
		return recipe_id;
	}



	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}



	@Override
	public int hashCode() {
		return Objects.hash(firstname, lastname, password, recipe_id, role_id, user_id, username);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(password, other.password) && recipe_id == other.recipe_id && role_id == other.role_id
				&& user_id == other.user_id && Objects.equals(username, other.username);
	}



	
}
