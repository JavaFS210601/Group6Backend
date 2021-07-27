package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.RoleDAOInterface;
import com.revature.models.database.UserRoles;

@Service
public class RoleService {

	private RoleDAOInterface roleDAO;

	@Autowired
	public RoleService(RoleDAOInterface roleDAO) {
		super();
		this.roleDAO = roleDAO;
	}



	public UserRoles saveRole(UserRoles role ) {
		return roleDAO.save(role);
	}



	public UserRoles findRoleById(int id) {
		// TODO Auto-generated method stub
		return roleDAO.getById( id);
	}
}
