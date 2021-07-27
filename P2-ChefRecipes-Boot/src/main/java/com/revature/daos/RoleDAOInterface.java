package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.database.UserRoles;
import com.revature.models.database.Users;


public interface RoleDAOInterface extends JpaRepository<UserRoles, Integer> {


}
