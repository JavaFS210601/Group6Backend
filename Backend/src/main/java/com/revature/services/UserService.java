package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserDAO;
import com.revature.models.User;

@Service
public class UserService {
	private UserDAO dao;
	
	
	@Autowired
	public UserService(UserDAO dao) {
		super();
		this.dao = dao;
	}



	public User[] getAll() {
		return dao.getAll();
		
	}
	
	public User getById(int id) {
		return dao.getById(id);
	}
	
	public User update(User a) {
		return dao.update(a);
	}
}
