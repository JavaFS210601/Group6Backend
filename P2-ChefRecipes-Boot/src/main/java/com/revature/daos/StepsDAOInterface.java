package com.revature.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.database.Steps;

public interface StepsDAOInterface extends JpaRepository<Steps, Integer> {
	
	@Transactional
	@Modifying
	@Query("Update Steps SET step = ?1"
			+ " WHERE step_id = ?2")
	void updateSteps(String step, int step_id);

}
