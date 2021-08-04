package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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


	public boolean updateUserFirstname(int id, String firstname) {
		
		userDAO.updateUserFirstname(id, firstname);
		Optional<Users> user = userDAO.findById(id);
		if (user != null) {
			return true;
		} else  {
			return false;
		}
		
	}


	public boolean deleteUser(Users user) {
		try {
			userDAO.delete(user);
			return true;
		} catch(IllegalArgumentException e) {
			
		}
		return false;
	}


	public Users findUserByUsernameAndPassword(String username, String password) {
		
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		
		//ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
			      .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
			      //.withMatcher("password", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		Example<Users> example = Example.of(user, customExampleMatcher);

		// find one with example user with only username and password
		//Optional<Users> actual = userDAO.findOne(example);
		List<Users> actual = userDAO.findAll(example);
		if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
		
		
		for (int i = 0 ; i< actual.size()  ;i++) {
	        if(!user.getPassword().equals(actual.get(i))){
	        	 
	            throw new RuntimeException("Password mismatch.");
	        }
		}
		return user;
	}


//	public Optional<List<Users>> findUserByUsernameAndPassword(String username, String password) {
//		// TODO Auto-generated method stub
//		return userDAO.findByUsernameAndPassword();
//	}
}
