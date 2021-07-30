package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.database.Steps;

public interface StepsDAOInterface extends JpaRepository<Steps, Integer> {

}
