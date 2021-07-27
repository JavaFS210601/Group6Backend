package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.database.Users;

public interface UserDAOInterface extends JpaRepository<Users, Integer> {
	//public Optional<List<Users>> findByUsernameAndPassword();
}
