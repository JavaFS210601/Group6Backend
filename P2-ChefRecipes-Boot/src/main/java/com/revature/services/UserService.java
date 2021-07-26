package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserDAO;
import com.revature.models.database.Users;

@Service
public class UserService {
	private UserDAO dao;
	
	
	@Autowired
	public UserService(UserDAO dao) {
		super();
		this.dao = dao;
	}



	public Users[] getAll() {
		return dao.getAll();
		
	}
	
	public Users getById(int id) {
		return dao.getById(id);
	}
	
	public Users update(Users a) {
		return dao.update(a);
	}
}
