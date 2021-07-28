package com.revature.daos;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.database.Users;

public interface UserDAOInterface extends JpaRepository<Users, Integer> {
	//public Optional<List<Users>> findByUsernameAndPassword();
	
	/*
	 * This is the way to define a customized jpa method
	 */
	@Transactional
	@Modifying(flushAutomatically = true)
	@Query("UPDATE Users AS u SET u.username = :value WHERE u.user_id= :id")
	public void updateUserFirstname( @Param("id") int id, @Param("value") String username) ;
}
