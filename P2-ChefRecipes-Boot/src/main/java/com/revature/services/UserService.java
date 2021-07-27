package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.RoleDAOInterface;
import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOInterface;
import com.revature.models.database.UserRoles;
import com.revature.models.database.Users;

@Service
public class UserService {
	private UserDAO dao;
	
	// JpaRepository
	private UserDAOInterface userDAO;
	
	@Autowired
	public UserService(UserDAO dao, UserDAOInterface userDAO) {
		super();
		this.dao = dao;
		this.userDAO = userDAO;
	}


	public Users saveUser(Users user) {
		
		return userDAO.save(user);
	}


	public Users[] getAll() {
		return dao.getAll();
		
	}
	
	public Users getById(int id) {
		return userDAO.findById(id).get();
	
	}
	
//	public Users update(Users a) {
//		return userDAO.;
//	}


	public List<Users> findAllUser() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}


//	public Optional<List<Users>> findUserByUsernameAndPassword(String username, String password) {
//		// TODO Auto-generated method stub
//		return userDAO.findByUsernameAndPassword();
//	}
}
