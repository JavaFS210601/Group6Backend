package com.revature.daos;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.database.Users;

public interface UserDAOInterface extends JpaRepository<Users, Integer> {
	//public Optional<List<Users>> findByUsernameAndPassword();
	
//	@Transactional(readOnly = true)
//	@Query("UPDATE users set WHERE "#user_id"=?1 ")
//	public Users update(int user_id) ;
}
