package com.revature.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.models.database.Recipes;
import com.revature.models.database.Users;
import com.revature.models.dtos.RecipeDTO;

public interface RecipeTransferDAO extends JpaRepository<RecipeDTO, Integer> {
	
	@Transactional
	//@Modifying(flushAutomatically = true)
	@Query(value ="INSERT INTO recipes (name, description, category, inspiration, user_id)"
			+ " VALUES(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
	Recipes save(@Param("1") String name, @Param("2") String description, @Param("3") String category, @Param("4") String inspiration, @Param("5") int id);

}
